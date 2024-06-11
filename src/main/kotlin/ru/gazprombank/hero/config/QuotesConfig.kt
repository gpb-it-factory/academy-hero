package ru.gazprombank.hero.config

import io.netty.channel.ChannelOption
import io.netty.handler.timeout.ReadTimeoutHandler
import io.netty.handler.timeout.WriteTimeoutHandler
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.web.reactive.function.client.WebClient
import reactor.netty.Connection
import reactor.netty.http.client.HttpClient
import reactor.netty.tcp.TcpClient
import java.util.concurrent.TimeUnit


@Configuration
@ConfigurationProperties(prefix = "quotes")
open class QuotesConfig(
    var quotesUrl: String = "",
    var baseUrl: String = "",
    private var timeout: Int = 0
) {

    @Bean
    open fun webClientWithTimeout(): WebClient {
        val tcpClient = TcpClient
            .create()
            .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, timeout)
            .doOnConnected { connection: Connection ->
                connection.addHandlerLast(ReadTimeoutHandler(timeout.toLong(), TimeUnit.MILLISECONDS))
                connection.addHandlerLast(WriteTimeoutHandler(timeout.toLong(), TimeUnit.MILLISECONDS))
            }

        return WebClient.builder()
            .baseUrl(baseUrl)
            .clientConnector(ReactorClientHttpConnector(HttpClient.from(tcpClient)))
            .build()
    }

}