
import domain.Server;
import domain.model.chat.Message;
import domain.model.util.RemoteObserver;
import domain.util.ClientObserver;
import misc.ConsolePrinter;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Message message = new Message();

        String username = "cliente";

        ConsolePrinter.INFO("cliente", "Insira seu username");
        message.setUser(scanner.nextLine());

        ConsolePrinter.INFO("cliente", "Nome de usuário cadastrado com sucesso: "+ message.getUser());
        ConsolePrinter.INFO("cliente", "Entrando no chat...");

        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 8081);
            Server server = (Server) Naming.lookup("rmi://localhost:8081/server");

            RemoteObserver observer = new ClientObserver(message.getUser());


            message.setText(String.format("%s entrou no chat!", message.getUser()));

            server.join(observer, message);

            ConsolePrinter.INFO("cliente", "conectado ao chat com sucesso!");

            //iniciando iterações do usuário:

            String resp = "";
            while (true){
                resp  = scanner.nextLine();
                message.setText(resp);

                server.sendMensage(message);
                message.setText(resp);
            }


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
