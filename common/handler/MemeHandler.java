/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.logging.log4j.Logger
 */
package com.meteor.extrabotany.common.handler;

import com.meteor.extrabotany.ExtraBotany;
import com.meteor.extrabotany.common.core.ConfigHandler;
import com.meteor.extrabotany.common.handler.ContributorListHandler;
import org.apache.logging.log4j.Logger;

public class MemeHandler {
    public static void spam() {
        Logger logger = ExtraBotany.LOGGER;
        if (!((Boolean)ConfigHandler.CLIENT.disablelogInfo.get()).booleanValue()) {
            logger.info("=============================================================================================");
            logger.info("*  _______   ___  ___   ___________    _______         __                                   *");
            logger.info("* /\"     \"| |\"  \\/\"  | (\"     _   \")  /\"      \\       /\"\"\\                                  *");
            logger.info("*(: ______)  \\   \\  /   )__/  \\\\__/  |:        |     /    \\                                 *");
            logger.info("* \\/    |     \\\\  \\/       \\\\_ /     |_____/   )    /' /\\  \\                                *");
            logger.info("* // ___)_    /\\.  \\       |.  |      //      /    //  __'  \\                               *");
            logger.info("*(:      \"|  /  \\   \\      \\:  |     |:  __   \\   /   /  \\\\  \\                              *");
            logger.info("* \\_______) |___/\\___|      \\__|     |__|  \\___) (___/    \\___)                             *");
            logger.info("*           _______       ______     ___________        __       _____  ___    ___  ___      *");
            logger.info("*          |   _  \"\\     /    \" \\   (\"     _   \")      /\"\"\\     (\\\"   \\|\"  \\  |\"  \\/\"  | \t *");
            logger.info("*          (. |_)  :)   // ____  \\   )__/  \\\\__/      /    \\    |.\\\\   \\    |  \\   \\  /  \t *");
            logger.info("*          |:     \\/   /  /    ) :)     \\\\_ /        /' /\\  \\   |: \\.   \\\\  |   \\\\  \\/   \t *");
            logger.info("*          (|  _  \\\\  (: (____/ //      |.  |       //  __'  \\  |.  \\    \\. |   /   /    \t *");
            logger.info("*          |: |_)  :)  \\        /       \\:  |      /   /  \\\\  \\ |    \\    \\ |  /   /     \t *");
            logger.info("*          (_______/    \\\"_____/         \\__|     (___/    \\___) \\___|\\____\\) |___/      \t *");
            logger.info("=============================================================================================");
            logger.info("*Thank you for installing ExtraBotany!                                                      *");
            logger.info("*Owner: ExtraMeteorP                                                                        *");
            logger.info("*Artist: MalayP, Gloridifice                                                                *");
            logger.info("*No more anime girl                                                                         *");
            logger.info("*If you want to disable it, check your config settings                                      *");
            logger.info("=============================================================================================");
            logger.info("*SPECIAL THANKS LIST                                                                        *");
            for (String key : ContributorListHandler.contributorsMap.keySet()) {
                logger.info("*" + String.format("%-24s %-65s", key + ":", ContributorListHandler.getRole(key)) + "*");
            }
            logger.info("=============================================================================================");
        }
    }
}
