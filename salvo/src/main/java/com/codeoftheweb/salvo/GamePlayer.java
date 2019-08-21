package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class GamePlayer {

  // ID automatico para la tabla "gamePlayers"
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
  @GenericGenerator(name = "native", strategy = "native")
  private long id;

  // Relacion con la tabla "games"
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "game_id")
  private Game game;

  // Relacion con la tabla "players"
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "player_id")
  private Player player;

  private Date joinDate;

  // Relacion con la tabla "ships"
  @OneToMany(mappedBy = "gamePlayer", fetch = FetchType.EAGER)
  Set<Ship> ships;

  public GamePlayer() {
    joinDate = new Date();
  }

  public GamePlayer(Game game, Player player) {
    this.game = game;
    this.player = player;
    joinDate = new Date();
  }

  public long getId() {
    return id;
  }

  public Game getGame() {
    return game;
  }

  public void setGame(Game game) {
    this.game = game;
  }

  public Player getPlayer() {
    return player;
  }

  public void setPlayer(Player player) {
    this.player = player;
  }

  public Date getJoinDate() {
    return joinDate;
  }

  public void setJoinDate(Date joinDate) {
    this.joinDate = joinDate;
  }

  public void addShip(Ship ship){
    ship.setGamePlayer(this);
    ships.add(ship);
  }

  public Set<Ship> getShips(){
    return ships;
  }
}
