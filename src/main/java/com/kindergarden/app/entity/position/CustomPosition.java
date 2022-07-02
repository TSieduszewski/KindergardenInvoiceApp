package com.kindergarden.app.entity.position;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("0")
public class CustomPosition extends Position{

}
