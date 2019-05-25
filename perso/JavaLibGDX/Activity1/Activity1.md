1) As classes **definidas** são as que compartilham o mesmo nome dos arquivos, portanto:

- `Drop`
- `DesktopLauncher`

É importante notar que a class `Drop` extende a classe `ApplicationAdapter` e esta é uma classe dentro da biblioteca libGDX

2) A classe `DesktopLauncher` não deriva/extende explicitamente de nada, mas implicitamente Java trata ela como uma derivada de `Object` (a classe mãe de todas as outras)

Já no caso de `Drop` extendendo de `ApplicationAdapter`, sua super classe apresenta métodos os quais a classe Drop faz Overrides, ou seja, define ela mesmo como que o método deveria funcionar. Assim a classe super trata a ordem dos métodos, mas quem define o que acontece nesses métodos é a classe `Drop`, abstraindo assim a lógica ao programador. Ele precisa apenas se preocupar no que acontece no `create()`, `render()` e `dispose()`

Resumindo, `DesktopLauncher` tem acesso a métodos e atributos básicos implementados dentro de `Object`, enquanto que `Drop` têm acesso a métodos `public` and `protected` dentro da sua superclasse, a qual também pode ter outras superclasses e no topo dessa hierarchia `Object` novamente

3) Em `Drop`

4) `private Array<Rectangle> raindrops;`

5) 2)

7) Sim. Ele é público, porque dentro de outra classe conseguimos acessar ele mesmo sem ser subclasse

8) É o nome de uma classe. O método Random que é chamado dentro dela deve ser `static` por não requerir uma instância da classe

9) Trata-se de uma instância de objeto. Lembrando que estamos apenas guardando a referência para aquele objeto. Se levar para baixo, estamos guardando um ponteiro para a classe, por assim dizer. A cada iteração do loop é criada uma instância a qual é atribuída a variável raindrop e esta é depois adicionada ao array de `Rectangle`

10) Porque ele refere ao atributo da classe e não uma variável local.