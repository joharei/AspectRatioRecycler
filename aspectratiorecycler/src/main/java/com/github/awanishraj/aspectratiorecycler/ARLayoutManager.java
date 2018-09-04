/*******************************************************************************
 * Copyright 2015 Awanish Raj
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.github.awanishraj.aspectratiorecycler;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Awanish Raj on 27/08/15.
 */
public class ARLayoutManager extends GridLayoutManager {

    /**
     * Default values of aspect ratio thresholds
     */
    private float ar_min = 2.0f;
    private float ar_max = 3.0f;

    private RecyclerView.Adapter mAdapter;
    private ARAdapterInterface adapterInterface;

    /**
     * Constructor for this layoutManager
     *
     * @param ARAdapterInterface For obtaining the dataset and adapter
     */
    public ARLayoutManager(Context context, ARAdapterInterface ARAdapterInterface) {
        super(context, 1);
        this.mAdapter = ARAdapterInterface.getAdapter();
        this.adapterInterface = ARAdapterInterface;
    }

    /**
     * Constructor for this layoutManager
     *
     * @param ARAdapterInterface For obtaining the dataset and adapter
     * @param ar_min             Minimum Aspect ratio required
     * @param ar_max             Maximum Aspect ratio limit
     */
    public ARLayoutManager(Context context, ARAdapterInterface ARAdapterInterface, float ar_min, float ar_max) {
        this(context, ARAdapterInterface);
        this.ar_max = ar_max;
        this.ar_min = ar_min;
    }

    /**
     * Method computes the cell dimensions, and notifies the Adapter
     */
    private void updateDataSet() {
        ARAspectComputer.SpanBucket result = ARAspectComputer.computeAspects(adapterInterface.getDataset(), getWidth(), ar_min, ar_max);
        this.setSpanCount(result.spanCount);
        this.setSpanSizeLookup(result.spanSizeLookup);
        this.mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onMeasure(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, int widthSpec, int heightSpec) {
        super.onMeasure(recycler, state, widthSpec, heightSpec);
        updateDataSet();
    }

    /**
     * Method to update the Aspect Ratio thresholds
     *
     * @param ar_min Minimum Aspect ratio required
     * @param ar_max Maximum Aspect ratio limit
     */
    public void setThresholds(float ar_min, float ar_max) {
        this.ar_min = ar_min;
        this.ar_max = ar_max;
        updateDataSet();
    }

}
