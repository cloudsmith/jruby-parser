/*
 ***** BEGIN LICENSE BLOCK *****
 * Version: CPL 1.0/GPL 2.0/LGPL 2.1
 *
 * The contents of this file are subject to the Common Public
 * License Version 1.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of
 * the License at http://www.eclipse.org/legal/cpl-v10.html
 *
 * Software distributed under the License is distributed on an "AS
 * IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * rights and limitations under the License.
 *
 * Copyright (C) 2009 Thomas E. Enebo <tom.enebo@gmail.com>
 * 
 * Alternatively, the contents of this file may be used under the terms of
 * either of the GNU General Public License Version 2 or later (the "GPL"),
 * or the GNU Lesser General Public License Version 2.1 or later (the "LGPL"),
 * in which case the provisions of the GPL or the LGPL are applicable instead
 * of those above. If you wish to allow use of your version of this file only
 * under the terms of either the GPL or the LGPL, and not to allow others to
 * use your version of this file under the terms of the CPL, indicate your
 * decision by deleting the provisions above and replace them with the notice
 * and other provisions required by the GPL or the LGPL. If you do not delete
 * the provisions above, a recipient may use your version of this file under
 * the terms of any one of the CPL, the GPL or the LGPL.
 ***** END LICENSE BLOCK *****/
package org.jrubyparser.ast;

/**
 * Base class for DefnNode and DefsNode 
 */
import org.jrubyparser.SourcePosition;
import org.jrubyparser.StaticScope;

public abstract class MethodDefNode extends Node implements INameNode {
	protected ArgumentNode nameNode;
	protected ArgsNode argsNode;
	protected StaticScope scope;
	protected Node bodyNode;

	public MethodDefNode(SourcePosition position, ArgumentNode nameNode, ArgsNode argsNode, 
	        StaticScope scope, Node bodyNode) {
            super(position);
            
            // TODO: Adding implicit nils caused multiple problems in compiler -- revist after landing
            //assert bodyNode != null : "bodyNode is not null";
            
            this.nameNode = nameNode;
            this.argsNode = argsNode;
            this.scope = scope;
            this.bodyNode = bodyNode;
	}

	/**
	 * Gets the argsNode.
	 * @return Returns a Node
	 */
	public ArgsNode getArgs() {
	    return argsNode;
	}
        
        @Deprecated
        public ArgsNode getArgsNode() {
            return getArgs();
        }

	/**
	 * Get the static scoping information.
	 * 
	 * @return the scoping info
	 */
	public StaticScope getScope() {
	    return scope;
	}

	/**
	 * Gets the body of this class.
	 * 
	 * @return the contents
	 */
	public Node getBody() {
	    return bodyNode;
	}
        
        @Deprecated
        public Node getBodyNode() {
            return getBody();
        }

	/**
	 * Gets the name's node.
	 * @return Returns an ArgumentNode
	 */
	public ArgumentNode getNameNode() {
	    return nameNode;
	}

	/**
	 * Gets the name.
	 * @return Returns a String
	 */
	public String getName() {
	    return nameNode.getName();
	}
}
