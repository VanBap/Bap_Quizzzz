package com.example.bap_quizzzz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.bap_quizzzz.databinding.ActivityMainBinding;
import com.example.bap_quizzzz.databinding.FragmentLevelBinding;

import org.json.JSONException;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    /// Bottom navigation + Fragment (Van 9/11/2022)
    ActivityMainBinding binding;
    //CategoryAdapter.CategoryViewHolder categoryViewHolder;
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
                    //reset so cau tra loi dung ve 0
                    HistoryFragment.resetCorrectCount();
                    break;
                case R.id.history:
                    replaceFragment(new HistoryFragment());
                    //reset so cau tra loi dung ve 0
                    HistoryFragment.resetCorrectCount();
                    break;
            }
            return true;
        });
        //

    }

    // Bottom navigation + Fragment (Van 9/11/2022)
    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.addToBackStack(null).commit();
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

                String subject = "Góp ý" + " từ " + getAndroidVersion();
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");

                shareIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"cloneson1766@gmail.com","vanbap20021599@gmail.com"});
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
                Toast.makeText(this, "Info", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }


    //Chon level
    public void chooseLevel(View view){
        switch (view.getId()){
            case R.id.easybtn:
                HistoryFragment.setLevel("easy"); // lưu trạng thái level mình nhấn vào
                QuestionFragment easyQuestionFragment = new QuestionFragment();
                replaceFragment(easyQuestionFragment);
                break;
            case R.id.mediumbtn:
                HistoryFragment.setLevel("medium");
                QuestionFragment mediumQuestionFragment = new QuestionFragment();
                replaceFragment(mediumQuestionFragment);
                break;
            case R.id.hardbtn:
                HistoryFragment.setLevel("hard");
                QuestionFragment hardQuestionFragment = new QuestionFragment();
                replaceFragment(hardQuestionFragment);
                break;
        }
    }

    //tro ve home
    public void goHome(View view){
        if(view.getId() == R.id.go_home){
            HomeFragment goHomeFragment = new HomeFragment();
            replaceFragment(goHomeFragment);
        }
        //store result -> history fragment
        HistoryFragment.AddHistoryList();

        //reset cau tra loi dung ve 0
        HistoryFragment.resetCorrectCount();

    }

    //chia se thanh tich
    public void shareResult(View view) {
        if(view.getId() == R.id.share_result){
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            String result = "Tôi đã trả lời đúng " + (HistoryFragment.getCorrectCount() + "/5") + " câu hỏi " + "cấp độ " + HistoryFragment.getLevel() + " ở chủ đề " + HistoryFragment.getTopic();
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
            shareIntent.putExtra(Intent.EXTRA_TEXT, result);
            startActivity(Intent.createChooser(shareIntent, null));

        }
    }

    //lay phien ban android cua user
    public String getAndroidVersion() {
        String release = android.os.Build.VERSION.RELEASE;  //The user-visible version string.
        int sdkVersion = android.os.Build.VERSION.SDK_INT;  //The SDK version of the software currently running on user's hardware device.
        return "Android SDK: API " + sdkVersion + " (Android version: " + release +")";
    }

    //nhan nut back tren dien thoai (co truong hop user nhan nut back de quay lai home)
    @Override
    public void onBackPressed() {
        HistoryFragment.resetCorrectCount(); //reset correctCount ve 0
        super.onBackPressed();
    }
}