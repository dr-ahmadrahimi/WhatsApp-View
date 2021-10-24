package dr.rahimi.ahmad.whatsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    RecyclerView WhatsApp_recyclerView;
    WhatsApp_MyChats WhatsApp_myChats;
    List<WhatsApp_Chats> WhatsApp_list;

    EditText WhatsApp_item_input;
    ImageView WhatsApp_emoji_icon, WhatsApp__attachment_icon, WhatsApp_camera_icon, WhatsApp_image, WhatsApp_mic_card_parent;

    Boolean WhatsApp_SendText = false;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WhatsApp_list = new ArrayList<>();
        WhatsApp_list.add(new WhatsApp_Chats(1, "10:48:11", R.drawable.whats_app_read, getString(R.string.whatsapp_chat_06)));
        WhatsApp_list.add(new WhatsApp_Chats(2, "10:46:09", R.drawable.whats_app_read, getString(R.string.whatsapp_chat_05)));
        WhatsApp_list.add(new WhatsApp_Chats(1, "10:37:35", R.drawable.whats_app_read, getString(R.string.whatsapp_chat_04)));
        WhatsApp_list.add(new WhatsApp_Chats(1, "10:37:00", R.drawable.whats_app_read, getString(R.string.whatsapp_chat_03)));
        WhatsApp_list.add(new WhatsApp_Chats(2, "10:36:28", R.drawable.whats_app_read, getString(R.string.whatsapp_chat_02)));
        WhatsApp_list.add(new WhatsApp_Chats(1, "10:35:48", R.drawable.whats_app_read, getString(R.string.whatsapp_chat_01)));

        WhatsApp_recyclerView = findViewById(R.id.WhatsApp_recyclerView);
        WhatsApp_recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        layoutManager.setStackFromEnd(true);
        WhatsApp_recyclerView.setLayoutManager(layoutManager);

        Collections.reverse(WhatsApp_list);
        WhatsApp_myChats = new WhatsApp_MyChats(this, WhatsApp_list);
        WhatsApp_recyclerView.setAdapter(WhatsApp_myChats);






        WhatsApp_image = findViewById(R.id.IMG_WhatsApp_user);
        WhatsApp_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Back Clicked !", Toast.LENGTH_SHORT).show();
            }
        });


        WhatsApp_emoji_icon = findViewById(R.id.IMG_WhatsApp_emoji);
        WhatsApp_emoji_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Emoji Clicked !", Toast.LENGTH_SHORT).show();
            }
        });


        WhatsApp__attachment_icon = findViewById(R.id.IMG_WhatsApp_attachment);
        WhatsApp__attachment_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Attach File's Clicked !", Toast.LENGTH_SHORT).show();
            }
        });


        WhatsApp_camera_icon = findViewById(R.id.IMG_WhatsApp_camera_icon);
        WhatsApp_camera_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Camera Clicked !", Toast.LENGTH_SHORT).show();
            }
        });





        WhatsApp_mic_card_parent = findViewById(R.id.IMG_WhatsApp_mic);
        WhatsApp_mic_card_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());

                if (WhatsApp_SendText) {
                    WhatsApp_list.add(new WhatsApp_Chats(1, currentTime, R.drawable.whats_app_read, WhatsApp_item_input.getText().toString().trim()));
                    WhatsApp_myChats = new WhatsApp_MyChats(getApplicationContext(), WhatsApp_list);
                    WhatsApp_recyclerView.setAdapter(WhatsApp_myChats);

                    WhatsApp_item_input.setText("");
                }

            }
        });



        WhatsApp_item_input = findViewById(R.id.TXT_WhatsApp_input);
        WhatsApp_item_input.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                WhatsApp_mic_card_parent.setImageResource(R.drawable.whats_app_send);
                WhatsApp_SendText = true;
                return false;
            }
        });




    }

}