package com.ksu4040e071.recycleview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class gridView extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview);
        GridView gvMember = (GridView) findViewById(R.id.gvMember);
        gvMember.setAdapter(new MemberAdapter(this));
        gvMember.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Member member = (Member) parent.getItemAtPosition(position);
                ImageView imageView = new ImageView(gridView.this);
                imageView.setImageResource(member.getImage());
                Toast toast = new Toast(gridView.this);
                toast.setView(imageView);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    private class MemberAdapter extends BaseAdapter {
        private LayoutInflater layoutInflater;
        private List<Member> memberList;

        public MemberAdapter(Context context) {
            layoutInflater = LayoutInflater.from(context);

            memberList = new ArrayList<>();
            memberList.add(new Member(23, R.drawable.movie01, "星際異攻隊2", "正式預告"));
            memberList.add(new Member(75, R.drawable.movie02, "神鬼傳奇", "前導預告"));
            memberList.add(new Member(65, R.drawable.movie03, "遇見街貓BOB", "30秒擊掌篇"));
            memberList.add(new Member(12, R.drawable.movie04, "遇見街貓BOB", "田亞霍中文宣傳曲MV"));
            memberList.add(new Member(92, R.drawable.movie05, "目擊者", "前導預告"));
            memberList.add(new Member(103, R.drawable.movie06, "黑金丑島君3─枷鎖篇", "中文預告"));
            memberList.add(new Member(45, R.drawable.movie07, "幸福湯屋", "中文預告"));
            memberList.add(new Member(78, R.drawable.movie08, "黑吃黑", "中文預告"));
            memberList.add(new Member(234, R.drawable.movie09, "樂來越愛你", "歌舞篇"));
            memberList.add(new Member(35, R.drawable.movie10, "鋼鐵英雄", "精彩版預告"));
            memberList.add(new Member(57, R.drawable.movie11, "夜行動物", "幕後花絮：故事篇"));
            memberList.add(new Member(61, R.drawable.movie12, "危險羅曼史", "危險羅曼史"));
        }

        @Override
        public int getCount() {
            return memberList.size();
        }

        @Override
        public Object getItem(int position) {
            return memberList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return memberList.get(position).getId();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.grid_item, parent, false);
            }

            Member member = memberList.get(position);
            ImageView ivImage = (ImageView) convertView
                    .findViewById(R.id.ivImage);
            ivImage.setImageResource(member.getImage());

            TextView tvContent = (TextView) convertView
                    .findViewById(R.id.tvContent);
            tvContent.setText(member.getContent());

            TextView tvName = (TextView) convertView
                    .findViewById(R.id.tvName);
            tvName.setText(member.getName());
            return convertView;
        }
    }
}