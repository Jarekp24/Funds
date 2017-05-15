package com.jarek.funds.model;

import com.jarek.funds.model.enums.FundType;

public class Fund {

        private Long Id;
        private String Name;
        private FundType type;

        public Fund() {
        }

        public Fund(Long Id, String Name, FundType type) {
                this.Id = Id;
                this.Name = Name;
                this.type = type;
        }

        public Long getId() {
                return Id;
        }

        public String getName() {
                return Name;
        }

        public FundType getType() {
                return type;
        }

}
