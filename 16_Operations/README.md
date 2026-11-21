# Java Operations: Linux, Containers, Deployment, and Monitoring

These are repeatable workflows for moving a Java service from a laptop toward
production. The companion `Dockerfile` packages the runnable task API from
`14_Backend_Development`; it does not imply that the demo API is production
ready.

## Linux service checks

```bash
java -version
ps -ef | grep '[j]ava'
ss -ltnp
journalctl -u task-api --since '15 minutes ago'
```

Run services as a dedicated unprivileged user. Keep configuration out of the
image, use a managed secret store, send logs to standard output, and configure
resource limits and graceful shutdown. Avoid logging tokens, passwords, or
personal data.

## Build and run the container

From the repository root with Docker installed:

```bash
docker build -t java-learning-task-api .
docker run --rm -p 8080:8080 java-learning-task-api
```

In another terminal, `curl -i http://localhost:8080/api/tasks`. The image runs
as a non-root user and binds its application port. Stop it with Ctrl-C.

## Deployment and operations checklist

1. Build once from a reviewed commit; deploy the same immutable image digest
   through environments.
2. Keep credentials, TLS certificates, and environment-specific values outside
   source control and the container image.
3. Use rolling or canary rollout with a health/readiness check and a documented
   rollback path. Do not treat successful image startup as application health.
4. Monitor request rate, error rate, latency percentiles, saturation, JVM heap
   and GC pauses, thread counts, and database connection-pool usage.
5. Correlate structured logs and distributed traces with request IDs. Alert on
   user-impacting symptoms and test alert delivery.
6. Back up persistent data, rehearse restores, and review database migrations
   before production rollout.

Cloud choices differ, but these controls still apply on a managed app platform,
container service, or Kubernetes. Start with the provider's managed identity,
secret store, health checks, logs, metrics, and deployment rollback features.
The task API uses volatile memory; containers can be replaced at any time and
therefore must not be used to store its data.
