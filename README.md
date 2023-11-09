# oidc-sample

## DBコンテナの起動

```bash
cd oidc-sample/oidc-db
docker compose up -d
```

## APIサーバの起動

```bash
cd oidc-sample/oidc-api
./mvnw spring-boot:run
# またはIntelliJで起動
```

## Clientの起動

```bash
# pnpmを有効化するため、Node.js v14.19.0またはv16.9.0以降を使用
corepack enable pnpm
pnpm --version

cd oidc-sample/oidc-client
pnpm i        # 初回のみ
pnpm run dev
```
