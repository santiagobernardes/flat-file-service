package com.fileservice.output.builder;

import com.fileservice.features.salesman.model.SalesmanModel;
import com.fileservice.output.model.OutputModel;

public class OutputBuilder {

        private Long amountOfClients;
        private Long amountOfSalesman;
        private Long idMostExpensiveSale;
        private SalesmanModel worstSalesmanEver;

        public OutputBuilder() {
        }

        public OutputBuilder amountClients(Long amountOfClients) {
            this.amountOfClients = amountOfClients;
            return this;
        }

        public OutputBuilder amountSalesman(Long amountOfSalesman) {
            this.amountOfSalesman = amountOfSalesman;
            return this;
        }

        public OutputBuilder idMostExpensiveSale(Long idMostExpensiveSale) {
            this.idMostExpensiveSale = idMostExpensiveSale;
            return this;
        }

        public OutputBuilder worstSalesmanEver(SalesmanModel worstSalesmanEver) {
            this.worstSalesmanEver = worstSalesmanEver;
            return this;
        }

        public OutputModel build() {
            return new OutputModel(amountOfClients, amountOfSalesman, idMostExpensiveSale, worstSalesmanEver);
        }
}
