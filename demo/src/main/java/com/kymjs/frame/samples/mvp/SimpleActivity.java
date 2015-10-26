/*
 * Copyright (c) 2015, 张涛.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kymjs.frame.samples.mvp;

import android.view.View;

import com.kymjs.frame.presenter.ActivityPresenter;
import com.kymjs.frame.samples.R;

/**
 * 在这里做业务逻辑操作，通过viewDelegate操作View层控件
 *
 * @author kymjs (http://www.kymjs.com/) on 10/23/15.
 */
public class SimpleActivity extends ActivityPresenter<SimpleDelegate> implements View
        .OnClickListener {

    @Override
    protected Class<SimpleDelegate> getDelegateClass() {
        return SimpleDelegate.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        viewDelegate.get(R.id.button1).setOnClickListener(this);
    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
//              也可以根据id得到这个控件(重复调用不会多次findview)
//              TextView tv = viewDelegate.get(R.id.helloword);
//              tv.setText("你点击了button");
                viewDelegate.setText("你点击了button");
                break;
        }
    }
}