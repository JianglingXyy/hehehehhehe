package com.ling.Pic.ui.register_login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.ling.Pic.R;
import com.ling.Pic.databinding.ActivityRegisterLoginBinding;

public class RegisterLoginActivity extends AppCompatActivity {
    private ActivityRegisterLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.toolbar1.getRoot().setNavigationIcon(R.drawable.ic_back);
        binding.toolbar1.getRoot().setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}