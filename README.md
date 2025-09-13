# Tópicos Avançados Java - Versões 8 a 22

Este repositório é destinado ao estudo da linguagem Java, abordando tópicos avançados das versões 8 até 22, com foco nas principais funcionalidades e melhorias introduzidas em cada versão.

## 📋 Objetivo

Fornecer uma base de estudos completa e prática para desenvolvedores que desejam:
- Compreender as evoluções da linguagem Java
- Dominar as funcionalidades avançadas de cada versão
- Aplicar os conceitos em projetos reais
- Acompanhar as tendências e melhores práticas

## 🗂️ Estrutura do Repositório

```
├── java8/          # Java 8 (LTS) - Lambda, Stream API, Optional
├── java9/          # Java 9 - Modules, JShell, Collection Factory Methods
├── java10/         # Java 10 - Local Variable Type Inference (var)
├── java11/         # Java 11 (LTS) - HTTP Client, String Methods
├── java12/         # Java 12 - Switch Expressions (Preview)
├── java13/         # Java 13 - Text Blocks (Preview)
├── java14/         # Java 14 - Records (Preview), Pattern Matching
├── java15/         # Java 15 - Text Blocks, Sealed Classes (Preview)
├── java16/         # Java 16 - Records, Pattern Matching for instanceof
├── java17/         # Java 17 (LTS) - Sealed Classes, Pattern Matching
├── java18/         # Java 18 - UTF-8 by Default, Simple Web Server
├── java19/         # Java 19 - Virtual Threads (Preview), Pattern Matching
├── java20/         # Java 20 - Scoped Values (Preview), Record Patterns
├── java21/         # Java 21 (LTS) - Virtual Threads, Pattern Matching
├── java22/         # Java 22 - Unnamed Variables, Foreign Function & Memory API
├── docs/           # Documentação adicional e guias de estudo
└── examples/       # Exemplos práticos e exercícios
```

## 🚀 Como Usar

### Pré-requisitos
- Java 22 instalado (compatível com versões anteriores)
- Maven 3.8+ ou Gradle 7+
- IDE de sua preferência (IntelliJ IDEA, Eclipse, VS Code)

### Executando os Exemplos

```bash
# Clone o repositório
git clone https://github.com/BlackCode777/01-topicos-avancados-java.git
cd 01-topicos-avancados-java

# Compile e execute exemplos específicos
cd java8
mvn compile exec:java

# Ou usando Gradle
gradle run
```

## 📚 Conteúdo por Versão

### Java 8 (LTS - 2014)
- **Lambda Expressions**: Programação funcional
- **Stream API**: Processamento de coleções
- **Optional**: Tratamento de valores nulos
- **Default Methods**: Métodos padrão em interfaces
- **Date/Time API**: Nova API de data e hora

### Java 9 (2017)
- **Module System**: Sistema de módulos (Project Jigsaw)
- **JShell**: REPL para Java
- **Collection Factory Methods**: Métodos de fábrica para coleções
- **Private Methods em Interfaces**

### Java 10 (2018)
- **Local Variable Type Inference**: Palavra-chave `var`
- **Application Class-Data Sharing**: Melhoria no startup
- **Garbage Collector Interface**: Interface unificada para GC

### Java 11 (LTS - 2018)
- **HTTP Client API**: Cliente HTTP nativo
- **String Methods**: Novos métodos para String
- **Files Methods**: Novos métodos para manipulação de arquivos
- **Lambda Parameters**: Var em parâmetros lambda

### Java 12 (2019)
- **Switch Expressions** (Preview): Nova sintaxe para switch
- **Compact Number Formatting**: Formatação compacta de números
- **Teeing Collector**: Novo collector para streams

### Java 13 (2019)
- **Text Blocks** (Preview): Strings multilinha
- **Switch Expressions**: Melhorias na versão preview
- **Dynamic CDS Archives**: Arquivos CDS dinâmicos

### Java 14 (2020)
- **Records** (Preview): Classes de dados imutáveis
- **Pattern Matching for instanceof** (Preview)
- **Switch Expressions**: Versão final
- **NullPointerException**: Mensagens mais informativas

### Java 15 (2020)
- **Text Blocks**: Versão final
- **Sealed Classes** (Preview): Classes seladas
- **Hidden Classes**: Classes ocultas
- **ZGC**: Melhorias no garbage collector

### Java 16 (2021)
- **Records**: Versão final
- **Pattern Matching for instanceof**: Versão final
- **Sealed Classes** (Segunda preview)
- **Vector API** (Incubator)

### Java 17 (LTS - 2021)
- **Sealed Classes**: Versão final
- **Pattern Matching for switch** (Preview)
- **Remove RMI Activation**: Remoção da ativação RMI
- **Strong Encapsulation**: Encapsulamento forte do JDK

### Java 18 (2022)
- **UTF-8 by Default**: UTF-8 como charset padrão
- **Simple Web Server**: Servidor web simples
- **Code Snippets in Documentation**: Snippets de código na documentação
- **Vector API** (Segunda incubator)

### Java 19 (2022)
- **Virtual Threads** (Preview): Threads virtuais
- **Pattern Matching for switch** (Terceira preview)
- **Foreign Function & Memory API** (Preview)
- **Structured Concurrency** (Incubator)

### Java 20 (2023)
- **Scoped Values** (Preview): Valores com escopo
- **Record Patterns** (Segunda preview)
- **Pattern Matching for switch** (Quarta preview)
- **Foreign Function & Memory API** (Segunda preview)

### Java 21 (LTS - 2023)
- **Virtual Threads**: Versão final
- **Pattern Matching for switch**: Versão final
- **Record Patterns**: Versão final
- **String Templates** (Preview)

### Java 22 (2024)
- **Unnamed Variables & Patterns**: Variáveis sem nome
- **Foreign Function & Memory API**: Versão final
- **String Templates** (Segunda preview)
- **Stream Gatherers** (Preview)

## 🎯 Exercícios e Projetos

Cada versão contém:
- **Exemplos práticos** demonstrando o uso das funcionalidades
- **Exercícios progressivos** para fixação do conteúdo
- **Projetos mini** aplicando os conceitos aprendidos
- **Comparações** entre diferentes abordagens

## 📖 Recursos Adicionais

- [Oracle Java Documentation](https://docs.oracle.com/en/java/)
- [OpenJDK](https://openjdk.org/)
- [Java Enhancement Proposals (JEPs)](https://openjdk.org/jeps/0)

## 🤝 Contribuição

Contribuições são bem-vindas! Por favor:
1. Faça um fork do projeto
2. Crie uma branch para sua feature
3. Commit suas mudanças
4. Abra um Pull Request

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

**Autor**: BlackCode777  
**Última atualização**: 2024