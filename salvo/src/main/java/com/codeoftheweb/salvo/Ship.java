package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Ship {

  // ID automatico para la tabla "ships"
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
  @GenericGenerator(name = "native", strategy = "native")
  private long id;

  private String shipType;

  // Relacion con la tabla "gamePlayers"
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "gameplayer_id")
  private GamePlayer gamePlayer;

  @ElementCollection
  @Column(name="location")
  private Set<String> locations = new HashSet<>();

  public Ship(){
  }

  public long getId() {
    return this.id;
  }

  public String getShipType() {
    return this.shipType;
  }

  public void setShipType(String shipType){
    this.shipType = shipType;
  }

  public GamePlayer getGamePlayer() {
    return this.gamePlayer;
  }

  public void setGamePlayer(GamePlayer gamePlayer){
    this.gamePlayer = gamePlayer;
  }

  public void addLocation(String location){
    locations.add(location);
  }

  public Set<String> getLocations(){
    return locations;
  }
}
