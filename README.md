# Android Card Slider like BannerLayout without Using ViewPager

Android : Card Slider or  Recycler view scalar transformation without viewPager like bannerLayout

How to :

1. Horizontally scroll item like Banner layout with animation:

        we have to create class with name of CenterZoomLayoutManager and extend the class from LinearLayoutManager
        
        /* create class with name of centerzoomlayoutmanager  */

        public class CenterZoomLayoutManager extends LinearLayoutManager {


         }

2. now, You have to declare the two static float type constants

       /* initialise two constant variable */
       private final float mShrinkAmount = 0.15f; 
       private final float mShrinkDistance = 0.9f;



3. Lets override the LinearLayouManager function scrollHorizontallyBy() and write our scalling code 

        int orientation = getOrientation(); //get the orientation of the device
        if (orientation == HORIZONTAL) {
            int scrolled = super.scrollHorizontallyBy(dx, recycler, state);
            float midpoint = getWidth() / 2.f;  //get the midpoint of the screen 
            float d0 = 0.f;
            float d1 = mShrinkDistance * midpoint; 
            float s0 = 1.f;
            float s1 = 1.f - mShrinkAmount;
            //set the view for all items of recycler view 
            for (int i = 0; i < getChildCount(); i++) {
                View child = getChildAt(i);
                float childMidpoint =
                        (getDecoratedRight(child) + getDecoratedLeft(child)) / 2.f;
                float d = Math.min(d1, Math.abs(midpoint - childMidpoint));
                float scale = s0 + (s1 - s0) * (d - d0) / (d1 - d0);
                child.setScaleX(scale);
                child.setScaleY(scale);
            }
            return scrolled;
        } else {
            return 0;
        }

4. if you have to use scalling vertically then you have to override the scrollVerticallyBy() method of LinearLayoutManager
                    
        int orientation = getOrientation(); //get the orientation of the device
        int orientation = getOrientation();
        if (orientation == VERTICAL) {
            int scrolled = super.scrollVerticallyBy(dy, recycler, state);
            float midpoint = getHeight() / 2.f;
            float d0 = 0.f;
            float d1 = mShrinkDistance * midpoint;
            float s0 = 1.f;
            float s1 = 1.f - mShrinkAmount;
            for (int i = 0; i < getChildCount(); i++) {
                View child = getChildAt(i);
                float childMidpoint =
                        (getDecoratedBottom(child) + getDecoratedTop(child)) / 2.f;
                float d = Math.min(d1, Math.abs(midpoint - childMidpoint));
                float scale = s0 + (s1 - s0) * (d - d0) / (d1 - d0);
                child.setScaleX(scale);
                child.setScaleY(scale);
            }
            return scrolled;
        } else {
            return 0;
        }

5. Now, we have to set this CenterZoomLayoutManager to recyclerView like LinearLayoutManager 

        /*custom linear layout manager to scaling between items*/
        CenterZoomLayoutManager centerZoomLayoutManager=new CenterZoomLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(centerZoomLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

6. for stopping the item scrolling in center of screen then you have to use SnapHelper (SnapHelper is a helper class that helps in          snapping any child view of the RecyclerView) 


       /*Snap helper for focus on center item while scrolling*/
       SnapHelper snapHelper = new PagerSnapHelper();
       snapHelper.attachToRecyclerView(recyclerView);

7. At the end you can now you can set your adapter class to your recyclerView

         recyclerView.setAdapter(mAdapter);
