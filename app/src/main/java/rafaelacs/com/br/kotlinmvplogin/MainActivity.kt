package rafaelacs.com.br.kotlinmvplogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_main.*
import rafaelacs.com.br.kotlinmvplogin.Presenter.ILoginPresenter
import rafaelacs.com.br.kotlinmvplogin.Presenter.LoginPresenter
import rafaelacs.com.br.kotlinmvplogin.View.ILoginView

class MainActivity : AppCompatActivity(), ILoginView {

    internal lateinit var loginPresenter: ILoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Init
        loginPresenter = LoginPresenter(this)

        //Event
        btn_login.setOnClickListener{
            loginPresenter.onLogin(edit_email.text.toString(), edit_password.text.toString())
        }
    }

    fun onLoginResult(message: String) {
        Toasty.info(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onLoginSuccess(message: String) {
        Toasty.success(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onLoginError(message: String) {
        Toasty.error(this, message, Toast.LENGTH_SHORT).show()
    }
}
