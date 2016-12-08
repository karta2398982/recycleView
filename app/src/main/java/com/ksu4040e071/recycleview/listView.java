package com.ksu4040e071.recycleview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class listView extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        ListView lvMember = (ListView) findViewById(R.id.lvMember);
        //取得liveView元件
        lvMember.setAdapter(new MemberAdapter(this));
        //建立Adapter基座（存取資料的地方）
        lvMember.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Member member = (Member) parent.getItemAtPosition(position);
                String text = member.getName();
                Toast.makeText(listView.this, text, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class MemberAdapter extends BaseAdapter {
        private LayoutInflater layoutInflater;
        private List<Member> memberList;
        //建立一個空的資料庫

        public MemberAdapter(Context context) {
            layoutInflater = LayoutInflater.from(context);
            //把資料存進MemberAdapter

            memberList = new ArrayList<>();
            //new一個memberList陣列
            memberList.add(new Member(12, R.drawable.news01, "【鏡週刊】台灣拖欠Lady Gaga權利金2年","作者鏡傳媒 | 鏡週刊 – 2016年12月5日 上午8:00"));
            memberList.add(new Member(75, R.drawable.news02, "黃士修觀點：政府不告訴你的電業法騙局","作者黃士修 | 風傳媒 – 2016年12月5日 上午7:46"));
            memberList.add(new Member(65, R.drawable.news03, "「竟有酒跟肉」法國人最愛台灣這碗麵", "作者三立新聞網 | 三立新聞 – 2016年12月5日 上午11:40"));
            memberList.add(new Member(12, R.drawable.news04, "吳宗憲二女兒曝光！露甜笑網友融化了", "作者三立新聞網 | 三立新聞 – 2016年12月5日 下午4:00"));
            memberList.add(new Member(92, R.drawable.news05, "可去地獄償罪但害怕死刑,謝依涵當庭痛哭", "作者上報快訊 | 上報 – 2016年12月5日 下午3:11"));
            memberList.add(new Member(103, R.drawable.news06, "蔡川通話風波》台灣早在熱線名單上 《華郵》：川普團隊策畫多時", "作者上報快訊 | 上報 – 2016年12月5日 下午6:46\n"));
            memberList.add(new Member(45, R.drawable.news07, "青年裸照恐嚇舊愛判入勞教中心　官斥行為可恥", "星島日報 – 3小時前"));
            memberList.add(new Member(78, R.drawable.news08, "電腦員認偷女同事「人奶」　求情指患抑鬱衝動犯案", "星島日報 – 6小時前"));
            memberList.add(new Member(234, R.drawable.news09, "又冷又暖　今周六23度下周四15度", "星島日報 – 6小時前"));
            memberList.add(new Member(35, R.drawable.news10, "葉望輝今下午與台灣媒體見面　暢談台美新關係", "作者朱蒲青／台北報導 | 民報 – 2016年12月6日 下午1:59"));
            memberList.add(new Member(57, R.drawable.news11, "王建民輕輕投 青棒小將：球很會跑", "中央社 – 2016年12月6日 下午3:23"));
            memberList.add(new Member(61, R.drawable.news12, "不受爆炸影響！三星Galaxy穩居韓國品牌榜第一", "作者編輯部 | 匯流新聞網 – 2016年12月6日 下午1:00"));
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
                convertView = layoutInflater.inflate(R.layout.list_item, parent, false);
            }

            Member member = memberList.get(position);
            ImageView ivImage = (ImageView) convertView
                    .findViewById(R.id.imageView);
            ivImage.setImageResource(member.getImage());

            TextView tvName = (TextView) convertView
                    .findViewById(R.id.tvName);
            tvName.setText(member.getName());

            TextView tvContent = (TextView) convertView
                    .findViewById(R.id.tvContent);
            tvContent.setText(member.getContent());
            return convertView;
        }
    }
}
