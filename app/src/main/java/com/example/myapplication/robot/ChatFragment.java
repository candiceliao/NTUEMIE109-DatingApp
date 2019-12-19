package com.example.myapplication.robot;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChatFragment extends Fragment {
    private List<ChatMessage> list;
    private ListView chat_listview;
    private EditText chat_input;
    private Button chat_send;
    private ChatMessageAdapter chatAdapter;
    private ChatMessage chatMessage = null;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View RobotChatRoot = inflater.inflate(R.layout.fragment_robot_chat, container, false);

        // 1.初始化
        chat_listview = RobotChatRoot.findViewById(R.id.chat_listView);
        chat_input = RobotChatRoot.findViewById(R.id.chat_input_message);
        chat_send = RobotChatRoot.findViewById(R.id.chat_send);

        // 2.設定監聽事件
        chat_send.setOnClickListener(onClickListener);

        // 3.初始化資料
        list = new ArrayList<ChatMessage>();
        list.add(new ChatMessage("您好,小乖為您服務!", ChatMessage.Type.INCOUNT, new Date()));
        chatAdapter = new ChatMessageAdapter(list);
        chat_listview.setAdapter(chatAdapter);
        chatAdapter.notifyDataSetChanged();
        return RobotChatRoot;
    }

    // 4.傳送訊息聊天
    private void chat() {
        // 1.判斷是否輸入內容
        final String send_message = chat_input.getText().toString().trim();
//        if (TextUtils.isEmpty(send_message)) {
//            Toast.makeText(MainActivity, "對不起，您還未傳送任何訊息",
//                    Toast.LENGTH_SHORT).show();
//            return;
//        }

        // 2.自己輸入的內容也是一條記錄，記錄重新整理
        ChatMessage sendChatMessage = new ChatMessage();
        sendChatMessage.setMessage(send_message);
        sendChatMessage.setData(new Date());
        sendChatMessage.setType(ChatMessage.Type.OUTCOUNT);
        list.add(sendChatMessage);
        chatAdapter.notifyDataSetChanged();
        chat_input.setText("");

        // 3.傳送你的訊息，去伺服器端，返回資料
        new Thread() {
            public void run() {
                ChatMessage chat = HttpUtils.sendMessage(send_message);
                Message message = new Message();
                message.what = 0x1;
                message.obj = chat;
                handler.sendMessage(message);
            }

            ;
        }.start();
    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {

        public void handleMessage(android.os.Message msg) {
            if (msg.what == 0x1) {
                if (msg.obj != null) {
                    chatMessage = (ChatMessage) msg.obj;
                }
                // 新增資料到list中，更新資料
                list.add(chatMessage);
                chatAdapter.notifyDataSetChanged();
            }
        }

        ;
    };

    // 點選事件監聽
    OnClickListener onClickListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.chat_send:
                    chat();
                    break;
            }
        }
    };

}
