package com.nick.wanandroid.ui


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.nick.wanandroid.R
import com.nick.wanandroid.entity.Result
import com.nick.wanandroid.entity.User
import com.nick.wanandroid.view_models.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.et_name
import kotlinx.android.synthetic.main.fragment_login.et_password
import kotlinx.android.synthetic.main.fragment_register.*


/**
 * A simple [Fragment] subclass.
 *
 */
class LoginFragment : Fragment() {
  private  var  loginViewModel :LoginViewModel?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginViewModel = ViewModelProviders.of(activity!!)[com.nick.wanandroid.view_models.LoginViewModel::class.java]
        tv_register.setOnClickListener {
            v ->
            Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_registerFragment)
        }
        et_name.setText("lixianzhongim@gmail.com")
        et_password.setText("bur806111")

        btn_login.setOnClickListener {
            when{
                et_name.text.isEmpty()->{
                    Toast.makeText(this@LoginFragment.context,"用户名为空",Toast.LENGTH_SHORT).show()
                }
                et_password.text.isEmpty()->{
                    Toast.makeText(this@LoginFragment.context,"密码为空",Toast.LENGTH_SHORT).show()
                }
                else ->{
                    Log.d("onViewCreated","login")
                    login()
                }
            }


        }
    }
  private  fun  login(){
        loginViewModel?.login(et_name.text.toString(),et_password.text.toString())
            ?.observe(this, Observer<Result<User>> {

                Log.d("destination",findNavController().currentDestination?.id.toString())
                if (it.errorCode == 0 ){
                    Toast.makeText(this@LoginFragment.context,"登录成功",Toast.LENGTH_SHORT).show()
                    loginViewModel!!.loginstate  = true
                    findNavController().popBackStack()
                }else{
                    Toast.makeText(this@LoginFragment.context,it.errorMsg,Toast.LENGTH_SHORT).show()
                }
            })
    }
}
