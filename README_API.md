# GAIA API REST

Backend Java do projeto GAIA convertido para uma API REST com Spring Boot.

## Requisitos

- Java 21+
- Maven 3.9+
- Acesso ao banco Oracle da FIAP

## Executar localmente

Defina as variáveis de ambiente:

Windows PowerShell:

```powershell
$env:GAIA_DB_URL="jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl"
$env:GAIA_DB_USER="SEU_RM"
$env:GAIA_DB_PASSWORD="SUA_SENHA"
```

Depois:

```bash
mvn clean spring-boot:run
```

A API inicia em:

```text
http://localhost:8080
```

## Deploy

A aplicação usa a variável `PORT`, permitindo hospedagem em plataformas que fornecem a porta por variável de ambiente.

As credenciais do Oracle não ficam no código. No servidor, configure:

- `GAIA_DB_URL`
- `GAIA_DB_USER`
- `GAIA_DB_PASSWORD`
