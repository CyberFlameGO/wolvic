package com.igalia.wolvic;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

public class LandingPageFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_landing_page, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((WebView) view.findViewById(R.id.web_view)).loadUrl(getString(R.string.landing_page_url));

        view.findViewById(R.id.button_learn_more).setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.hvr_learn_more_url)));
            startActivity(intent);
        });

        view.findViewById(R.id.button_dismiss).setOnClickListener(v ->
                getView().findViewById(R.id.glass_banner).setVisibility(View.GONE));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitle(R.string.app_name);
            toolbar.showOverflowMenu();
            toolbar.inflateMenu(R.menu.app_menu);
            toolbar.setOnMenuItemClickListener(item -> {
                if (item.getItemId() == R.id.terms_service) {
                    // TODO
                    return true;
                } else if (item.getItemId() == R.id.privacy_policy) {
                    // TODO
                    return true;
                }
                return false;
            });
        }
    }
}