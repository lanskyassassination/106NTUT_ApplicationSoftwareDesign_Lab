package com.example.user.lab6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    class Data {
        int photo;
        String name;
    }

    public class myAdapter extends BaseAdapter{
        private Data[] data;
        private int view;

        public myAdapter(Data[] data, int view){
            this.data = data;
            this.view = view;
        }


        @Override
        public int getCount() {
            return data.length;
        }

        @Override
        public Object getItem(int position) {
            return data[position];;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            rowView = getLayoutInflater().inflate(view, parent, false);
            TextView name = (TextView) rowView.find

            return null;
        }

    }
}
