package org.osm2world.core.world.modules;

import org.osm2world.core.map_data.data.MapNode;
import org.osm2world.core.map_elevation.data.GroundState;
import org.osm2world.core.math.VectorXZ;
import org.osm2world.core.world.data.NoOutlineNodeWorldObject;
import org.osm2world.core.world.modules.common.AbstractModule;

/**
 * creates invisible world objects that are not rendered,
 * but nevertheless contain important information (such as elevation at a point)
 */
public class InvisibleModule extends AbstractModule {
	
	@Override
	protected void applyToNode(MapNode node) {
		if (node.getTags().containsKey("ele")
				&& node.getRepresentations().isEmpty()) {
			node.addRepresentation(new InvisibleEleNode(node));
		}
	}
	
	private static class InvisibleEleNode extends NoOutlineNodeWorldObject {
		
		public InvisibleEleNode(MapNode node) {
			super(node);
		}
		
		@Override
		public double getClearingAbove(VectorXZ pos) {
			return 0;
		}
		
		@Override
		public double getClearingBelow(VectorXZ pos) {
			return 0;
		}
		
		@Override
		public GroundState getGroundState() {
			return GroundState.ON;
		}
		
	}
	
}