package com.application.cafe;

/**
 * The addIn class contains enum variables representing possible additional ingredients a client can add to their coffee.
 * @author Steven Li, Jason Yang
 *
 */
public enum addIn {
    CREAM{
        /**
         * Returns name of addIn as a string.
         * @return String Cream
         */
        @Override
        public String toString() {
            return "Cream";
        }
    },
    SYRUP{
        /**
         * Returns name of addIn as a string.
         * @return String Cream
         */
        @Override
        public String toString() {
            return "Syrup";
        }
    },
    MILK{
        /**
         * Returns name of addIn as a string.
         * @return String Cream
         */
        @Override
        public String toString() {
            return "Milk";
        }
    },
    CARAMEL{
        /**
         * Returns name of addIn as a string.
         * @return String Cream
         */
        @Override
        public String toString() {
            return "Caramel";
        }
    },
    WHIPPED_CREAM{
        /**
         * Returns name of addIn as a string.
         * @return String Cream
         */
        @Override
        public String toString() {
            return "Whipped Cream";
        }
    };
}
