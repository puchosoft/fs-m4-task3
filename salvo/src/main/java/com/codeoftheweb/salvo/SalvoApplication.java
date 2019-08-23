package com.codeoftheweb.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

@SpringBootApplication
public class SalvoApplication {

  public static void main(String[] args) {
    SpringApplication.run(SalvoApplication.class, args);
  }

  // Este codigo se ejecuta al inicio de la aplicacion
  @Bean
  public CommandLineRunner initData(PlayerRepository pRepository,
                                    GameRepository gRepository,
                                    GamePlayerRepository gpRepository,
                                    ShipRepository sRepository) {
    return (args) -> {

      Game game;
      GamePlayer gp;
      Ship ship;

      // guardamos algunos players
      pRepository.save(new Player("j.bauer@ctu.gov"));
      pRepository.save(new Player("c.obrian@ctu.gov"));
      pRepository.save(new Player("kim_bauer@gmail.com"));
      pRepository.save(new Player("t.almeida@ctu.gov"));

      // guardamos algunos games
      gRepository.save(new Game());
      game = new Game();
      game.setCreationDate(Date.from(game.getCreationDate().toInstant().plus(Duration.ofHours(1))));
      gRepository.save(game);
      game = new Game();
      game.setCreationDate(Date.from(game.getCreationDate().toInstant().plus(Duration.ofHours(2))));
      gRepository.save(game);
      game = new Game();
      game.setCreationDate(Date.from(game.getCreationDate().toInstant().plus(Duration.ofHours(3))));
      gRepository.save(game);
      game = new Game();
      game.setCreationDate(Date.from(game.getCreationDate().toInstant().plus(Duration.ofHours(4))));
      gRepository.save(game);
      game = new Game();
      game.setCreationDate(Date.from(game.getCreationDate().toInstant().plus(Duration.ofHours(5))));
      gRepository.save(game);
      game = new Game();
      game.setCreationDate(Date.from(game.getCreationDate().toInstant().plus(Duration.ofHours(6))));
      gRepository.save(game);
      game = new Game();
      game.setCreationDate(Date.from(game.getCreationDate().toInstant().plus(Duration.ofHours(7))));
      gRepository.save(game);

      // guardamos algunos gamePlayers
      gpRepository.save(new GamePlayer(gRepository.getOne(1L), pRepository.getOne(1L)));
      gpRepository.save(new GamePlayer(gRepository.getOne(1L), pRepository.getOne(2L)));
      gpRepository.save(new GamePlayer(gRepository.getOne(2L), pRepository.getOne(1L)));
      gpRepository.save(new GamePlayer(gRepository.getOne(2L), pRepository.getOne(2L)));
      gpRepository.save(new GamePlayer(gRepository.getOne(3L), pRepository.getOne(2L)));
      gpRepository.save(new GamePlayer(gRepository.getOne(3L), pRepository.getOne(4L)));
      gpRepository.save(new GamePlayer(gRepository.getOne(4L), pRepository.getOne(2L)));
      gpRepository.save(new GamePlayer(gRepository.getOne(4L), pRepository.getOne(1L)));
      gpRepository.save(new GamePlayer(gRepository.getOne(5L), pRepository.getOne(4L)));
      gpRepository.save(new GamePlayer(gRepository.getOne(5L), pRepository.getOne(1L)));
      gpRepository.save(new GamePlayer(gRepository.getOne(6L), pRepository.getOne(3L)));
      gpRepository.save(new GamePlayer(gRepository.getOne(7L), pRepository.getOne(4L)));
      gpRepository.save(new GamePlayer(gRepository.getOne(8L), pRepository.getOne(3L)));
      gpRepository.save(new GamePlayer(gRepository.getOne(8L), pRepository.getOne(4L)));

      // guardamos algunas ships
      ship = new Ship("Destroyer", gpRepository.getOne(1L));
      ship.setLocations(new HashSet<>(Arrays.asList("H2", "H3", "H4")));
      sRepository.save(ship);

      ship = new Ship("Submarine", gpRepository.getOne(1L));
      ship.setLocations(new HashSet<>(Arrays.asList("E1", "F1", "G1")));
      sRepository.save(ship);

      ship = new Ship("Patrol Boat", gpRepository.getOne(1L));
      ship.setLocations(new HashSet<>(Arrays.asList("B4", "B5")));
      sRepository.save(ship);

      ship = new Ship("Destroyer", gpRepository.getOne(2L));
      ship.setLocations(new HashSet<>(Arrays.asList("B5", "C5", "D5")));
      sRepository.save(ship);

      ship = new Ship("Patrol Boat", gpRepository.getOne(2L));
      ship.setLocations(new HashSet<>(Arrays.asList("F1", "F2")));
      sRepository.save(ship);

      ship = new Ship("Destroyer", gpRepository.getOne(3L));
      ship.setLocations(new HashSet<>(Arrays.asList("B5", "C5", "D5")));
      sRepository.save(ship);

      ship = new Ship("Patrol Boat", gpRepository.getOne(3L));
      ship.setLocations(new HashSet<>(Arrays.asList("C6", "C7")));
      sRepository.save(ship);

      ship = new Ship("Submarine", gpRepository.getOne(4L));
      ship.setLocations(new HashSet<>(Arrays.asList("A2", "A3", "A4")));
      sRepository.save(ship);

      ship = new Ship("Patrol Boat", gpRepository.getOne(4L));
      ship.setLocations(new HashSet<>(Arrays.asList("G6", "H6")));
      sRepository.save(ship);

      ship = new Ship("Destroyer", gpRepository.getOne(5L));
      ship.setLocations(new HashSet<>(Arrays.asList("B5", "C5", "D5")));
      sRepository.save(ship);

      ship = new Ship("Patrol Boat", gpRepository.getOne(5L));
      ship.setLocations(new HashSet<>(Arrays.asList("C6", "C7")));
      sRepository.save(ship);

      ship = new Ship("Submarine", gpRepository.getOne(6L));
      ship.setLocations(new HashSet<>(Arrays.asList("A2", "A3", "A4")));
      sRepository.save(ship);

      ship = new Ship("Patrol Boat", gpRepository.getOne(6L));
      ship.setLocations(new HashSet<>(Arrays.asList("G6", "H6")));
      sRepository.save(ship);

      ship = new Ship("Destroyer", gpRepository.getOne(7L));
      ship.setLocations(new HashSet<>(Arrays.asList("B5", "C5", "D5")));
      sRepository.save(ship);

      ship = new Ship("Patrol Boat", gpRepository.getOne(7L));
      ship.setLocations(new HashSet<>(Arrays.asList("C6", "C7")));
      sRepository.save(ship);

      ship = new Ship("Submarine", gpRepository.getOne(8L));
      ship.setLocations(new HashSet<>(Arrays.asList("A2", "A3", "A4")));
      sRepository.save(ship);

      ship = new Ship("Patrol Boat", gpRepository.getOne(8L));
      ship.setLocations(new HashSet<>(Arrays.asList("G6", "H6")));
      sRepository.save(ship);

      ship = new Ship("Destroyer", gpRepository.getOne(9L));
      ship.setLocations(new HashSet<>(Arrays.asList("B5", "C5", "D5")));
      sRepository.save(ship);

      ship = new Ship("Patrol Boat", gpRepository.getOne(9L));
      ship.setLocations(new HashSet<>(Arrays.asList("C6", "C7")));
      sRepository.save(ship);

      ship = new Ship("Submarine", gpRepository.getOne(10L));
      ship.setLocations(new HashSet<>(Arrays.asList("A2", "A3", "A4")));
      sRepository.save(ship);

      ship = new Ship("Patrol Boat", gpRepository.getOne(10L));
      ship.setLocations(new HashSet<>(Arrays.asList("G6", "H6")));
      sRepository.save(ship);

      ship = new Ship("Destroyer", gpRepository.getOne(11L));
      ship.setLocations(new HashSet<>(Arrays.asList("B5", "C5", "D5")));
      sRepository.save(ship);

      ship = new Ship("Patrol Boat", gpRepository.getOne(11L));
      ship.setLocations(new HashSet<>(Arrays.asList("C6", "C7")));
      sRepository.save(ship);

      ship = new Ship("Destroyer", gpRepository.getOne(13L));
      ship.setLocations(new HashSet<>(Arrays.asList("B5", "C5", "D5")));
      sRepository.save(ship);

      ship = new Ship("Patrol Boat", gpRepository.getOne(13L));
      ship.setLocations(new HashSet<>(Arrays.asList("C6", "C7")));
      sRepository.save(ship);

      ship = new Ship("Submarine", gpRepository.getOne(14L));
      ship.setLocations(new HashSet<>(Arrays.asList("A2", "A3", "A4")));
      sRepository.save(ship);

      ship = new Ship("Patrol Boat", gpRepository.getOne(14L));
      ship.setLocations(new HashSet<>(Arrays.asList("G6", "H6")));
      sRepository.save(ship);

    };
  }
}
