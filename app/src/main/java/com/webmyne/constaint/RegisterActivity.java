package com.webmyne.constaint;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.webmyne.constaint.custom.TfButton;
import com.webmyne.constaint.custom.TfTextView;

import net.cachapa.expandablelayout.ExpandableLayout;

public class RegisterActivity extends AppCompatActivity {

    private TfTextView txtCollapse;
    private ExpandableLayout expandablePersonalDetail;
    private ImageView imgPersonalArrow;
    private TfTextView txtAddress;
    private ImageView imgAddArrow;
    private ExpandableLayout expandableAddLayout;
    private TfButton btnNext;
    private TfButton btnNextMemberShipPlan;
    private ExpandableLayout expandableMembershipDetail;
    private ImageView imgMembershipPlanArrow;
    private TfTextView txtMembership;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtCollapse = (TfTextView) findViewById(R.id.txtCollapse);
        txtAddress = (TfTextView) findViewById(R.id.txtAddress);
        txtMembership = (TfTextView) findViewById(R.id.txtMembership);
        expandablePersonalDetail = (ExpandableLayout) findViewById(R.id.expandablePersonalDetail);
        expandableAddLayout = (ExpandableLayout) findViewById(R.id.expandableAddLayout);
        expandableMembershipDetail = (ExpandableLayout) findViewById(R.id.expandableMembershipDetail);
        imgPersonalArrow = (ImageView) findViewById(R.id.imgPersonalArrow);
        imgAddArrow = (ImageView) findViewById(R.id.imgAddArrow);
        imgMembershipPlanArrow = (ImageView) findViewById(R.id.imgMembershipPlanArrow);

        btnNext = (TfButton) findViewById(R.id.btnNext);
        btnNextMemberShipPlan = (TfButton) findViewById(R.id.btnNextMemberShipPlan);

        txtCollapse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (expandablePersonalDetail.isExpanded()) {
                    ObjectAnimator animation = ObjectAnimator.ofFloat(imgPersonalArrow, "rotation", 0f, 180f);
                    animation.setDuration(400).start();
                    expandablePersonalDetail.collapse();
                } else {
                    ObjectAnimator animation = ObjectAnimator.ofFloat(imgPersonalArrow, "rotation", 180f, 0f);
                    animation.setDuration(400).start();
                    expandablePersonalDetail.expand();
                }
            }
        });

        txtAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (expandableAddLayout.isExpanded()) {
                    ObjectAnimator animation = ObjectAnimator.ofFloat(imgAddArrow, "rotation", 0f, 180f);
                    animation.setDuration(400).start();
                    expandableAddLayout.collapse();
                } else {
                    ObjectAnimator animation = ObjectAnimator.ofFloat(imgAddArrow, "rotation", 180f, 0f);
                    animation.setDuration(400).start();
                    expandableAddLayout.expand();
                }
            }
        });

        txtMembership.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (expandableMembershipDetail.isExpanded()) {
                    ObjectAnimator animation = ObjectAnimator.ofFloat(imgMembershipPlanArrow, "rotation", 180f, 0f);
                    animation.setDuration(400).start();
                    expandableMembershipDetail.collapse();
                } else {
                    ObjectAnimator animation = ObjectAnimator.ofFloat(imgMembershipPlanArrow, "rotation", 0f, 180f);
                    animation.setDuration(400).start();
                    expandableMembershipDetail.expand();
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextButtonClick();
            }
        });

        btnNextMemberShipPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnNextMemberShipPlanClick();
            }
        });
    }

    private void nextButtonClick() {
        if (expandablePersonalDetail.isExpanded()) {
            if (expandablePersonalDetail.isExpanded()) {
                ObjectAnimator animation = ObjectAnimator.ofFloat(imgPersonalArrow, "rotation", 0f, 180f);
                animation.setDuration(400).start();

                expandablePersonalDetail.collapse();
                ObjectAnimator animation1 = ObjectAnimator.ofFloat(imgAddArrow, "rotation", 0f, 180f);
                animation1.setDuration(400).start();
                expandableAddLayout.expand();
            }
        }
    }

    private void btnNextMemberShipPlanClick() {
        if (expandableAddLayout.isExpanded()) {
            if (expandableAddLayout.isExpanded()) {
                ObjectAnimator animation = ObjectAnimator.ofFloat(imgAddArrow, "rotation", 0f, 180f);
                animation.setDuration(400).start();
                expandableAddLayout.collapse();
                ObjectAnimator animation1 = ObjectAnimator.ofFloat(imgMembershipPlanArrow, "rotation", 0f, 180f);
                animation1.setDuration(400).start();
                expandableMembershipDetail.expand();
            }
        }
    }
}
