/* ========================================================================
 * PlantUML : a free UML diagram generator
 * ========================================================================
 *
 * (C) Copyright 2009-2024, Arnaud Roques
 *
 * Project Info:  https://plantuml.com
 * 
 * If you like this project or if you find it useful, you can support us at:
 * 
 * https://plantuml.com/patreon (only 1$ per month!)
 * https://plantuml.com/paypal
 * 
 * This file is part of PlantUML.
 *
 * PlantUML is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PlantUML distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public
 * License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 *
 * Original Author:  Arnaud Roques
 *
 */
package net.sourceforge.plantuml.filesdiagram;

import java.util.List;

import net.sourceforge.plantuml.klimt.drawing.UGraphic;
import net.sourceforge.plantuml.klimt.font.FontConfiguration;
import net.sourceforge.plantuml.klimt.font.StringBounder;
import net.sourceforge.plantuml.klimt.font.UFont;
import net.sourceforge.plantuml.klimt.geom.XDimension2D;
import net.sourceforge.plantuml.klimt.shape.AbstractTextBlock;
import net.sourceforge.plantuml.style.ISkinParam;

public class FilesListing extends AbstractTextBlock {

	private final ISkinParam skinParam;
	private final FontConfiguration fontConfiguration = FontConfiguration.blackBlueTrue(UFont.courier(14));
	private final FEntry root;

	public FilesListing(ISkinParam skinParam) {
		this.skinParam = skinParam;
		this.root = FEntry.createRoot(skinParam);
	}

	@Override
	public XDimension2D calculateDimension(StringBounder stringBounder) {
		return new XDimension2D(200, 200);
	}

	@Override
	public void drawU(UGraphic ug) {
		for (FEntry ent : root)
			ug = ent.drawAndMove(ug, fontConfiguration, skinParam, 0);
	}

	public void addRawEntry(String raw) {
		root.addRawEntry(raw, skinParam);
	}

	public void addNote(List<String> note) {
		root.addNote(note, skinParam);
	}

}
