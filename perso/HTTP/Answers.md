1) Temos referências para:

- urlstr e data >>> String
- url >>> URL
- con >>> HttpURLConnection
- IOException (também é uma classe)

2) Definida em java.net, 6 construtores, 22 métodos

3) url.openConnection retorna um objeto que pode ser convertido para HttpURLConnection, ou seja, dentro da chamada do método deve haver um new.

4) class sun.net.www.protocol.https.HttpsURLConnectionImpl, está definido dentro de Object, URL extende Object

5) OutputStream

6) Não será compilado por que OutputStream pode lançar uma exceção desse tipo e como tal uma classe que usa OutputStream também