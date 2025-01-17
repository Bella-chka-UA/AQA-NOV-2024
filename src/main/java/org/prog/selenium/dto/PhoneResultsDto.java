package org.prog.selenium.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class PhoneResultsDto {
        private String id;
        private String name;
        private String goodsId;

        public PhoneResultsDto(String id, String name, String goodsId) {
            this.id = id;
            this.name = name;
            this.goodsId = goodsId;
        }

        // Геттеры
        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getGoodsId() {
            return goodsId;
        }

        @Override
        public String toString() {
            return "PhoneResultsDto{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", goodsId='" + goodsId + '\'' +
                    '}';
        }
    }


