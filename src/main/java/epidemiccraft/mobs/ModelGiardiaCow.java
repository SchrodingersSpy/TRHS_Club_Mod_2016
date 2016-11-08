
package epidemiccraft.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelGiardiaCow extends ModelBase
{
  //fields
    ModelRenderer horn1;
    ModelRenderer head;
    ModelRenderer horn2;
    ModelRenderer bodyfront;
    ModelRenderer bodymiddle;
    ModelRenderer bodyback;
    ModelRenderer udders;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4upper;
    ModelRenderer leg4lower;
  
  public ModelGiardiaCow()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      horn1 = new ModelRenderer(this, 0, 50);
      horn1.addBox(0F, 0F, 0F, 1, 3, 1);
      horn1.setRotationPoint(2.9F, -0.5F, -12F);
      horn1.setTextureSize(128, 64);
      horn1.mirror = true;
      setRotation(horn1, 0.2974216F, 0F, 0F);
      head = new ModelRenderer(this, 0, 28);
      head.addBox(-4F, -4F, -6F, 8, 8, 6);
      head.setRotationPoint(0F, 4F, -7.5F);
      head.setTextureSize(128, 64);
      head.mirror = true;
      setRotation(head, 0.2974216F, 0F, 0F);
      horn2 = new ModelRenderer(this, 4, 50);
      horn2.addBox(0F, 0F, 0F, 1, 3, 1);
      horn2.setRotationPoint(-3.9F, -0.5F, -12F);
      horn2.setTextureSize(128, 64);
      horn2.mirror = true;
      setRotation(horn2, 0.2974216F, 0F, 0F);
      bodyfront = new ModelRenderer(this, 48, 18);
      bodyfront.addBox(-6F, -10F, -7F, 12, 6, 10);
      bodyfront.setRotationPoint(0F, 7F, 2F);
      bodyfront.setTextureSize(128, 64);
      bodyfront.mirror = true;
      setRotation(bodyfront, 1.45926F, 0F, 0F);
      bodymiddle = new ModelRenderer(this, 48, 0);
      bodymiddle.addBox(0F, 0F, 0F, 12, 8, 10);
      bodymiddle.setRotationPoint(-6F, 13.5F, -3F);
      bodymiddle.setTextureSize(128, 64);
      bodymiddle.mirror = true;
      setRotation(bodymiddle, 1.570796F, 0F, 0F);
      bodyback = new ModelRenderer(this, 48, 34);
      bodyback.addBox(0F, 0F, 0F, 12, 6, 10);
      bodyback.setRotationPoint(-6F, 2.933333F, 9.5F);
      bodyback.setTextureSize(128, 64);
      bodyback.mirror = true;
      setRotation(bodyback, -1.459252F, 0F, 0F);
      udders = new ModelRenderer(this, 0, 42);
      udders.addBox(-2F, -3F, 0F, 4, 6, 2);
      udders.setRotationPoint(0F, 13F, 7F);
      udders.setTextureSize(128, 64);
      udders.mirror = true;
      setRotation(udders, -1.448623F, 0F, 0F);
      leg1 = new ModelRenderer(this, 0, 0);
      leg1.addBox(0F, 0F, 0F, 4, 12, 4);
      leg1.setRotationPoint(1.9F, 12F, -8F);
      leg1.setTextureSize(128, 64);
      leg1.mirror = true;
      setRotation(leg1, 0F, 0F, 0F);
      leg2 = new ModelRenderer(this, 16, 0);
      leg2.addBox(0F, 0F, 0F, 4, 12, 4);
      leg2.setRotationPoint(-5.9F, 12F, -8F);
      leg2.setTextureSize(128, 64);
      leg2.mirror = true;
      setRotation(leg2, 0F, 0F, 0F);
      leg3 = new ModelRenderer(this, 32, 0);
      leg3.addBox(0F, 0F, 0F, 4, 12, 4);
      leg3.setRotationPoint(1.9F, 12F, 5.5F);
      leg3.setTextureSize(128, 64);
      leg3.mirror = true;
      setRotation(leg3, 0F, 0F, 0F);
      leg4upper = new ModelRenderer(this, 16, 16);
      leg4upper.addBox(0F, 0F, 0F, 4, 7, 4);
      leg4upper.setRotationPoint(-6F, 10.3F, 6.3F);
      leg4upper.setTextureSize(128, 64);
      leg4upper.mirror = true;
      setRotation(leg4upper, -0.4461433F, 0F, 0F);
      leg4lower = new ModelRenderer(this, 0, 16);
      leg4lower.addBox(0F, 0F, 0F, 4, 8, 4);
      leg4lower.setRotationPoint(-6F, 16.5F, 3.3F);
      leg4lower.setTextureSize(128, 64);
      leg4lower.mirror = true;
      setRotation(leg4lower, 0.2230717F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    horn1.render(f5);
    head.render(f5);
    horn2.render(f5);
    bodyfront.render(f5);
    bodymiddle.render(f5);
    bodyback.render(f5);
    udders.render(f5);
    leg1.render(f5);
    leg2.render(f5);
    leg3.render(f5);
    leg4upper.render(f5);
    leg4lower.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	float f6 = (180F / (float)Math.PI);
    	this.leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    	this.leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    	this.leg3.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
  }

}
