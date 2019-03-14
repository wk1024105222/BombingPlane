package wk.game.BombPlane;

import java.util.Collections;

public class PlaneMap {
	Plane onePlane;
	Plane twoPlane;
	Plane threePlane;
	
	PlaneMap() {
		this.onePlane = new Plane();
		this.twoPlane = new Plane();
		this.threePlane = new Plane();
		boolean b = Collections.disjoint(onePlane.body,twoPlane.body) 
			&& Collections.disjoint(twoPlane.body,threePlane.body) 
			&& Collections.disjoint(threePlane.body,onePlane.body)
			&& (this.onePlane.head != this.twoPlane.head) 
			&& (this.threePlane.head != this.twoPlane.head)
			&& (this.onePlane.head != this.threePlane.head) ;
		while(b == false) {
			this.onePlane = new Plane();
			this.twoPlane = new Plane();
			this.threePlane = new Plane();
			b = Collections.disjoint(onePlane.body,twoPlane.body) 
			&& Collections.disjoint(twoPlane.body,threePlane.body) 
			&& Collections.disjoint(threePlane.body,onePlane.body)
			&& (this.onePlane.head != this.twoPlane.head) 
			&& (this.threePlane.head != this.twoPlane.head)
			&& (this.onePlane.head != this.threePlane.head) ;
		}
		/*System.out.print(onePlane.head+" ");
		for (int i=0; i!=onePlane.body.size(); i++) {
			System.out.print(onePlane.body.get(i)+" ");
		}
		System.out.print("\n");
		System.out.print(twoPlane.head+" ");
		for (int i=0; i!=twoPlane.body.size(); i++) {
			System.out.print(twoPlane.body.get(i)+" ");
		}
		System.out.print("\n");
		System.out.print(threePlane.head+" ");
		for (int i=0; i!=threePlane.body.size(); i++) {
			System.out.print(threePlane.body.get(i)+" ");
		}
		System.out.print("\n");*/
	}
}
