package rafaelacs.com.br.kotlinmvplogin.Model

interface IUser {

    val email: String
    val password: String
    fun isDataValid(): Int

}