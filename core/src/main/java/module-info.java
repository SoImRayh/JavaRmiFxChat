module dev.rayh.core {

    requires static lombok;
    requires java.rmi;

    exports dev.rayh.core.domain.chat;
    exports dev.rayh.core.util;
    exports dev.rayh.core.misc;
    exports dev.rayh.core;
}