/*
 * Copyright (c) 2016, Imagination Technologies Limited and/or its affiliated group companies
 * and/or licensors
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted
 * provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions
 *     and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of
 *     conditions and the following disclaimer in the documentation and/or other materials provided
 *     with the distribution.
 *
 * 3. Neither the name of the copyright holder nor the names of its contributors may be used to
 *     endorse or promote products derived from this software without specific prior written
 *     permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY
 * WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */


package com.imgtec.creator.iup.fragments.common;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.imgtec.creator.iup.activities.BaseToolbarActivity;
import com.imgtec.creator.iup.fragments.navigationdrawer.NDListeningFragment;

/**
 * Fragment capable of changing title of the ActionBar of activity the fragment is attached to.
 * Changing the title is based on fragment's lifecycle.
 */
public abstract class FragmentWithTitle extends NDListeningFragment {


  protected Toolbar toolbar;


  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    toolbar = ((BaseToolbarActivity) getActivity()).getToolbar();
    //actionBarTitle = (TextView) (toolbar.findViewById(R.id.toolbar_title));
  }

  @Override
  public void onResume() {
    super.onResume();
    toolbar.setTitle(getActionBarTitleText());
  }

  @Override
  public void onDestroyView() {
    toolbar.setTitle("");
    super.onDestroyView();
  }

  protected abstract String getActionBarTitleText();

}
