package test;

import fspm.config.Config;
import fspm.config.params.ParamCategory;

public class DropNotes {
  /**
   * Advantage: using the same category without worrying about dupes in other categories
   * 
   * This is because key checking only occurs when they are in the same category
   */

  public void Advantages() {
    ParamCategory CONFIG = Config.getInstance()
      .getParamConfig()
      .getCategory("myCategory");

    CONFIG.getBool("myBoolean1");
    CONFIG.getBool("myBoolean2");
    CONFIG.getBool("myBoolean3");

    CONFIG = Config.getInstance()
      .getParamConfig()
      .getCategory("otherCategory");

    CONFIG.getInt("something else");
  }

  /**
   * Disadvantage: tedious when switching categories multiple times
   */
  public void Disadvantages() {
    ParamCategory CONFIG = Config.getInstance()
      .getParamConfig()
      .getCategory("myCategory");

    CONFIG.getBool("myBoolean1");



    CONFIG = Config.getInstance()
      .getParamConfig()
      .getCategory("otherCategory");

    CONFIG.getInt("something else");


    
    CONFIG = Config.getInstance()
      .getParamConfig()
      .getCategory("anotherCategory");

    CONFIG.getBool("something");
  }
}
