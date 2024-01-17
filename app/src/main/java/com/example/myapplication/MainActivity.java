package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button bCamera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = (TextView)this.findViewById(R.id.textViewId);
        registerForContextMenu(tv);
     }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        menu.setHeaderTitle("Sample Context Menu");
    menu.add(200, 200, 200, "Author");
    }



    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == 200) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Автор")
                    .setMessage("Астроух В. Д.")
                    .setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // Закрываем диалоговое окно
                            dialog.cancel();
                        }
                    }).show();
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menu_Author:
            case 105:
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Автор")
                        .setMessage("Астроух В. Д.")
                        .setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // Закрываем диалоговое окно
                                dialog.cancel();
                            }
                        }).show();

                break;
            }

        }
        return true;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater(); // от явления
        inflater.inflate(R.menu.my_menu, menu);
        addSubMenu(menu);
// Чтобы можно было увидеть меню, должен быть возвращен результат true
        return true;
    }

    private void addSubMenu(Menu menu) {
// вспомогательные элементы показаны так же, как и любые другие
        int base=101;
        SubMenu sm = menu.addSubMenu(base, base+1, Menu.NONE, "submenu");
        MenuItem item = sm.add(base, base+2, base+2, "subiteml");
        item.setIcon(R.drawable.cpu);
        item = sm.add(base, base+3, base+3, "subitem2");
        item.setIcon(R.drawable.mortarboard);
        item = sm.add(base, base+4, base+4, "Author");
        item.setIcon(R.drawable.user);
    }


}