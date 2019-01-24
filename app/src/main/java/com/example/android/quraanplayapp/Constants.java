package com.example.android.quraanplayapp;

public enum Constants {
    SURAA_DATA {
        public String toString() {
            return "SuraaData";
        }
    },
    SHEIKH_DATA {
        public String toString() {
            return "SheikhData";
        }
    },
    SURAAS_LIST_VIEW_DATA {
        @Override
        public String toString() {
            return "SuraasListViewData";
        }
    },

}
