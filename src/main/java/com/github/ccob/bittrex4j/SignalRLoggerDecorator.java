/*
 * *
 *  This file is part of the bittrex4j project.
 *
 *  @author CCob
 *
 *  For the full copyright and license information, please view the LICENSE
 *  file that was distributed with this source code.
 * /
 */

package com.github.ccob.bittrex4j;


import com.github.signalr4j.client.LogLevel;
import com.github.signalr4j.client.Logger;

public class SignalRLoggerDecorator implements Logger {

    org.slf4j.Logger log;
    LogLevel loggingLevel;

    SignalRLoggerDecorator(org.slf4j.Logger log, LogLevel loggingLevel) {
        this.log = log;
        this.loggingLevel = loggingLevel;
    }

    @Override
    public void log(String message, LogLevel level) {
        switch (level){
            case Critical:
                log.error(message);
                break;
            case Information:
                if (this.loggingLevel == LogLevel.Verbose ||
                    this.loggingLevel == LogLevel.Information) {
                    log.info(message);
                }
                break;
            case Verbose:
                if (this.loggingLevel == LogLevel.Verbose) {
                    log.debug(message);
                }
                break;
        }
    }
}
