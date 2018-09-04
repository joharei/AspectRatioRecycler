/*******************************************************************************
 * Copyright 2015 Awanish Raj
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.github.awanishraj.aspectratiorecycler;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Created by Awanish Raj on 12/10/15.
 */
public interface ARAdapterInterface {

    /**
     * Method to obtain the RecyclerView Adapter
     * @return
     */
    RecyclerView.Adapter getAdapter();

    /**
     * Method to obtain the dataset for the RecyclerView
     * @return
     */
    List<? extends DimInterface> getDataset();

}
