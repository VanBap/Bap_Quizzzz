package com.example.bap_quizzzz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.bap_quizzzz.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    /// Bottom navigation + Fragment (Van 9/11/2022)
    ActivityMainBinding binding;
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Bottom navigation + Fragment (Van 9/11/2022)
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.history:
                    replaceFragment(new HistoryFragment());
                    break;
            }
            return true;
        });
        //
    }

    // Bottom navigation + Fragment (Van 9/11/2022)
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
    //


    ///Toolbar (Son_10/11/22)

    //ham tao menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //lay cai layout toolbar
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //tao event khi click vao options trong menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.menuShare:
                //String address = "cloneson1766@gmail.com";
                String subject = "Góp ý";
                Intent shareIntent = new Intent(Intent.ACTION_SENDTO);
                //shareIntent.setType("text/plain");
                shareIntent.setData(Uri.parse("mailto:cloneson1766@gmail.com, vanbap20021599@gmail.com"));
                //shareIntent.putExtra(Intent.EXTRA_EMAIL, address);
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, subject);

                //check co app gmail de mo khong
                if(shareIntent.resolveActivity(getPackageManager()) != null){
                    startActivity(shareIntent);
                }else{
                    Toast.makeText(MainActivity.this, "No App is installed", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.menuInfo:
                replaceFragment(new InfoFragment());
                Toast.makeText(this, "Ban chon Info", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
    //


}