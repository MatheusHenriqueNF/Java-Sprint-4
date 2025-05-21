# 📍 ViaSmart - API REST JAVA QUARKUS

Este repositório contém o código-fonte da API REST **ViaSmart**, desenvolvido com **JAVA** e voltado para um totem de consulta de rotas, dúvidas frequentes e gerenciamento de colaboradores.


### Clone a API em JAVA
```bash
# Clone o repositório
git clone https://github.com/MatheusHenriqueNF/Java-Sprint-4
````

---
## 🔧 Como rodar a API Java (Quarkus) no IntelliJ IDEA

### ✅ Pré-requisitos

* **Java 17** instalado ([OpenJDK 17](https://jdk.java.net/17/))
* **Maven** instalado ou configurado pelo IntelliJ
* **IntelliJ IDEA** (Community ou Ultimate)
* Conexão ativa com o banco de dados Oracle
* A API clonada localmente

---

### 💡 Instalar o plugin do Quarkus no IntelliJ

1. Abra o IntelliJ IDEA
2. Vá até `File > Settings > Plugins`

 ![image](https://github.com/user-attachments/assets/705c1ef7-0dcf-4afe-8241-1f0292099a5b)

3. Busque por **Quarkus** no Marketplace

![image](https://github.com/user-attachments/assets/6ec2b20b-3477-42e2-af0d-ac8b68856ed3)


4. Clique em **Install**
5. Reinicie o IntelliJ após a instalação

---

### 🚀 Executar a API no IntelliJ

1. **Importe o projeto:**

   * Vá em `File > Open` e selecione a pasta do projeto da API Java
   * O IntelliJ reconhecerá o projeto Maven automaticamente

  ![image](https://github.com/user-attachments/assets/cd72b62a-3bcf-4872-89d4-b97cc87ab498)


2. **Verifique o arquivo `pom.xml`:**

   * Certifique-se de que todas as dependências estão resolvidas (ícone verde no canto superior direito)

3. **Configure as variáveis de ambiente (se necessário):**

   * Como `QUARKUS_DATASOURCE_USERNAME`, `QUARKUS_DATASOURCE_PASSWORD` e `QUARKUS_DATASOURCE_JDBC_URL`
   * Isso pode ser feito dentro da aba `Edit Configurations` > `Application` > `Environment variables`

4. **Execute a API pelo RUN:**

   * RUN > Selecione o run com Quarkus

![image](https://github.com/user-attachments/assets/f5e56bd9-ce26-4488-a7ff-43ecf77d3d8e)


5. **Execute a API pelo TERMINAL:**

   * TERMINAL > Digite:  mvn quarkus:dev
   * ⚠️ Verifique se está no diretório correto, caso execute o código fora do repositória da API não irá funcionar

6. **A API estará disponível em:**

   ```
   http://localhost:8080
   ```

---

### 📌 Endpoints úteis

* **Login:** `POST http://localhost:8080/login`
* **Listar estações:** `GET http://localhost:8080/estacoes-linhas`
* **Dúvidas frequentes:** `GET http://localhost:8080/duvidas`

> Garanta que o CORS está habilitado no projeto Quarkus (`application.properties`):

```properties
quarkus.http.cors=true
```

---

## 🪖 Integrantes do Grupo

* **CLEYTON ENRIKE DE OLIVEIRA** – RM 560485 - Turma 1TDSQ
* **MATHEUS HENRIQUE NASCIMENTO DE FREITAS** – RM 560442 - Turma 1TDSQ
* **MATHEUS PINHEIRO ERMACORA MARTIN** – RM 557720 - Turma 1TDSZ
