package com.company.Dio.FilmesEmCartaz;

public enum GeneroTipo {
        TERROR("TERRO"), ROMANCE("ROMANCE"),ACAO("AÇAO"), COMEDIA("COMEDIA");

        public String getGenero() {
                return genero;
        }

        private String genero;
        GeneroTipo(String genero){
                this.genero = genero;
        }
}
