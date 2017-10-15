package com.mcmoddev.basemetals.init;

import java.util.Arrays;
import java.util.List;

import com.mcmoddev.basemetals.data.MaterialNames;
import com.mcmoddev.lib.util.ConfigBase.Options;

/**
 * This class initializes all fluids in Base Metals.
 *
 * @author Jasmine Iwanek
 *
 */
public class Fluids extends com.mcmoddev.lib.init.Fluids {

	private static boolean initDone = false;

	private Fluids() {
		throw new IllegalAccessError("Not a instantiable class");
	}

	/**
	 *
	 */
	public static void init() {
		if (initDone) {
			return;
		}

		// Vanilla Materials need to always have fluids available in case of tie-in mods
		List<String> vanilla_material_names = Arrays.asList( MaterialNames.CHARCOAL, MaterialNames.COAL, MaterialNames.DIAMOND, 
				MaterialNames.EMERALD, MaterialNames.GOLD, MaterialNames.IRON, MaterialNames.OBSIDIAN, MaterialNames.PRISMARINE,
				MaterialNames.REDSTONE );
		
		List<String> my_standard_materials = Arrays.asList( MaterialNames.ADAMANTINE, MaterialNames.ANTIMONY, MaterialNames.AQUARIUM,
				MaterialNames.BISMUTH, MaterialNames.BRASS, MaterialNames.BRONZE, MaterialNames.COLDIRON, MaterialNames.COPPER,
				MaterialNames.CUPRONICKEL, MaterialNames.ELECTRUM, MaterialNames.INVAR, MaterialNames.LEAD, MaterialNames.MITHRIL,
				MaterialNames.NICKEL, MaterialNames.PEWTER, MaterialNames.PLATINUM, MaterialNames.SILVER, MaterialNames.STARSTEEL,
				MaterialNames.STEEL, MaterialNames.TIN, MaterialNames.ZINC );
		
		vanilla_material_names.forEach( name -> {
			addFluid( name, 2000, 10000, 769, 10 );
			addFluidBlock( name );
		});

		my_standard_materials.stream()
		.filter(name -> Options.isMaterialEnabled(name) )
		.forEach( name -> {
			addFluid( name, 2000, 10000, 769, 10 );
			addFluidBlock( name );
		});
		
		if (Options.isMaterialEnabled(MaterialNames.MERCURY)) {
			addFluid(MaterialNames.MERCURY, 13594, 2000, 769, 0);
			addFluidBlock(MaterialNames.MERCURY);
		}

		initDone = true;
	}
}
