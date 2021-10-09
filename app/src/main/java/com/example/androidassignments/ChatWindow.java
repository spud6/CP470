package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatWindow extends AppCompatActivity {

    ArrayList<String> chatmsgs = new ArrayList<String>();

    private class ChatAdapter extends ArrayAdapter<String> {
        public ChatAdapter(Context ctx){
            super(ctx, 0);
        }

        public int getCount(){
            return chatmsgs.size();
        }

        public String getItem(int position){
            return chatmsgs.get(position);
        }

        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = ChatWindow.this.getLayoutInflater();

            View result = null;

            if(position%2 == 0)

                result = inflater.inflate(R.layout.chat_row_incoming, null);

            else

                result = inflater.inflate(R.layout.chat_row_outgoing, null);

            TextView message = (TextView)result.findViewById(R.id.message_text);
            message.setText(getItem(position)); // get the string at position

            return result;
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);

        ListView lv = findViewById(R.id.msgList);
        EditText et = findViewById(R.id.sendEdit);
        Button b = findViewById(R.id.sendButton);

        ChatAdapter messageAdapter = new ChatAdapter(this);
        lv.setAdapter (messageAdapter);

        b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String msg = et.getText().toString();
                chatmsgs.add(msg);
                messageAdapter.notifyDataSetChanged();
                et.setText("");
            }
        });
    }
}