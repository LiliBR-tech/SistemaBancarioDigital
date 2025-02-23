 <img width=100% src="https://capsule-render.vercel.app/api?type=waving&color=FF0000&height=150&section=header&text=💰+Sistema+Bancario+Digital+Java+☕&fontSize=25&fontColor=ffffff&animation=twinkling&fontAlignY=35"/>
 
  [![Typing SVG](https://readme-typing-svg.herokuapp.com/?color=FF0000&size=35&center=true&vCenter=true&width=1000&lines=💎Criptomoedas+Futuro+Financeiro+Descentralizado)](https://git.io/typing-svg)<br>


  <img src="https://github.com/LiliBR-tech/SistemaBancarioDigitalJava/blob/main/assets/Java-Logo.png" 
   alt="db3c90cd-1ead-4209-82fd-bb60b9b8e58d" min-width="100px" max-width="100px" width="100px" align="right"> <br>


## 📌 **Descrição**  
✔️ Este projeto simula um **Banco Digital** simples, com funcionalidades de contas bancárias como **contas correntes**, **contas poupanças**, **transferências**, **saques**, **Pix**, **investimentos**, **empréstimos**, **financiamentos**, **notificação de extratos**, **limite de crédito** e **cashback**. O sistema também possui exceções personalizadas para garantir a integridade das operações bancárias.

## 🚀 **Tecnologias Utilizadas**
- 🔹 **Java 17+**  
- 🔹 **VSCode**, **IntelliJ IDEA** ou **Eclipse** (opcional)  
- 🔹 **Git/GitHub** para versionamento  
- 🔹 **JUnit** para testes unitários  

## 📂 **Estrutura do Projeto**  
📌 Este projeto segue uma organização modular e de fácil manutenção, focando em boas práticas de desenvolvimento.

# 📂 Estrutura do Projeto

📌 Este projeto segue uma organização modular para facilitar a manutenção e escalabilidade.

| **Arquivo/Pasta**                                | **Descrição**                                       |
|--------------------------------------------------|-----------------------------------------------------|
| 📂 **.github/workflows/**                        | 📁 Contém automações do GitHub Actions              |
| ├── `java.yml`                                   | 🔧 Configuração do GitHub Actions para CI/CD        |
| 📂 **src/main/java/br/com/SistemaBancario/utils/**| 📁 Contém utilitários para JSON e segurança         |
| ├── `JsonUtils.java`                             | 🔧 Manipulação de arquivos JSON                     |
| ├── `SecurityUtils.java`                         | 🔒 Utilitário para segurança e criptografia         |
| 📂 **src/main/java/br/com/SistemaBancario/**      | 📁 Código-fonte principal do sistema bancário       |
| ├── `Cliente.java`                               | 👤 Representação de um cliente no sistema bancário  |
| ├── `Conta.java`                                 | 💳 Representação de uma conta bancária             |
| ├── `ContaCorrente.java`                         | 💰 Classe que representa uma Conta Corrente, com funcionalidades específicas
| ├── `ContaPoupanca.java`                         | 💰 Classe que representa uma Conta Poupança, com funcionalidades específicas               |
| ├── `Criptomoeda.java`                           | 🪙 Representação e conversão de criptomoedas        |
| ├── `GerenciamentoClientes.java`                 | 📋 Gerenciamento de clientes                        |
| ├── `GerenciamentoContas.java`                   | 📑 Gerenciamento de contas bancárias                |
| ├── `GerenciamentoCriptomoedas.java`             | 🔄 Gerenciamento de criptomoedas                     |
| └── `SistemaBancario.java`                       | 🚀 Classe principal para inicializar o sistema      |
| 📂 **src/main/resources/**                       | 📁 Contém arquivos de configuração                  |
| ├── `config.yml`                                 | ⚙️ Arquivo de configurações                         |
| 📂 **src/test/java/br/com/SistemaBancario/**      | 📁 Testes unitários do sistema                      |
| ├── `ClienteTest.java`                           | 🧪 Testes para a classe `Cliente`                   |
| ├── `CriptomoedaTest.java`                       | 🧪 Testes para a classe `Criptomoeda`               |
| `.gitignore`                                     | 🗑️ Arquivo para ignorar arquivos desnecessários    |
| `LICENSE`                                        | 📜 Licença do projeto                               |
| `README.md`                                      | 📚 Documentação detalhada do projeto               |

### 📌 **Observação:**
- O código-fonte está localizado em `src/main/java/br/com/banco/`.
- Testes unitários podem ser encontrados em `src/test/java/br/com/banco/`.
- O projeto é gerenciado por **Java** e **GitHub Actions**.

## 🎯 **Como Executar o Projeto**
1. **Clone o repositório:**
   git clone https://github.com/seuusuario/BancoDigitalJava.git
 
2. Navegue até a pasta do projeto:
   cd BancoDigitalJava

3. Compile o projeto:
   javac -d bin src/br/com/banco/*.java

4. Execute a aplicação:
   java -cp bin br.com.banco.Main

5. Interaja com o sistema:<br>
🔵 O sistema solicitará para que você insira um número de conta e um valor para realizar operações bancárias (depósitos, saques, transferências, etc.).

## 🔥 Exemplo de Execução
👉 Digite o número da conta: 12345<br>
👉 Digite o valor: 1000.00<br>
🔵 Caso o saldo da conta seja insuficiente para saque:<br>
✔️ Exception in thread "main" br.com.banco.exceptions.SaldoInsuficienteException: Saldo insuficiente para saque.

## 📌 Regras de Negócio
🔹💳 Limite de Crédito na ContaCorrente.<br>
🔹💰 Rendimento na ContaPoupanca.<br>
🔹💸 Empréstimos e financiamentos disponíveis para clientes com boas condições financeiras.<br>
🔹📑 Notificação de extrato: o sistema envia notificações ao cliente toda vez que uma transação é realizada.<br>
🔹🏦 Pix: Transferências rápidas entre contas.<br>
🔹🔄 Cashback: Cliente ganha cashback em transações realizadas com sua conta.<br>
🔹💼 Investimentos: Clientes podem investir valores para obter rendimentos adicionais.<br>

## 📜 Licença
✔️ Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.<br>

## 💡 Dicas:
</> Se precisar personalizar ou melhorar a documentação, fique à vontade! 😃

## 👨‍💻 Autor

<p>
    <img 
      align=left 
      margin=10 
      width=80 
      src="https://avatars.githubusercontent.com/u/186736248?v=4"
    />
    <p>&nbsp&nbsp&nbspLilianBR<br>
    &nbsp&nbsp&nbsp
    <a 
        href="https://github.com/LiliBR-tech">
        GitHub
    </a>
    &nbsp;|&nbsp;
    <a 
        href="https://www.linkedin.com/">
        LinkedIn
    </a>
    &nbsp;|&nbsp;
    <a 
        href="https://www.instagram.com/">
        Instagram
    </a>
    &nbsp;|&nbsp;</p>
</p>
<br/><br/>
<p>
