# Netty in Spring Boot 3

Uses `WebClient` with reactor `HttpClient` to fetch something from httpbin.org.

## JVM

```
gradle bootRun
```

## Native image

```
gradle nativeCompile
build/native/nativeCompile/netty-timeout-restart --logging.level.io.netty=TRACE --logging.level.reactor.netty=TRACE
```

It just hangs, the last log messages are:

```
[ctor-http-nio-1] io.netty.resolver.dns.DnsQueryContext    : [id: 0xa3f4060c] WRITE: UDP, [56936: /127.0.0.53:53], DefaultDnsQuestion(httpbin.org. IN A)
[ctor-http-nio-1] io.netty.resolver.dns.DnsQueryContext    : [id: 0xa3f4060c] WRITE: UDP, [18753: /127.0.0.53:53], DefaultDnsQuestion(httpbin.org. IN AAAA)
```
