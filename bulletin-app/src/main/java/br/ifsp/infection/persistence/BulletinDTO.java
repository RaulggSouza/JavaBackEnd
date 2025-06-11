package br.ifsp.infection.persistence;

public record BulletinDTO(int id, String city, String state, int infected, int deaths, double icu_ratio, String date) {
}
