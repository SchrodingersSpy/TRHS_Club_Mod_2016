package epidemiccraft.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelEColiChicken extends ModelBase
{
  //fields
    ModelRenderer Head;
    ModelRenderer Beak;
    ModelRenderer Neck;
    ModelRenderer Body;
    ModelRenderer Wing2;
    ModelRenderer Wing1;
    ModelRenderer Leg1;
    ModelRenderer Leg2;
  
  public ModelEColiChicken()
  {
    textureWidth = 52;
    textureHeight = 29;
    
      Head = new ModelRenderer(this, 0, 14);
      Head.addBox(0F, 0F, 0F, 4, 6, 4);
      Head.setRotationPoint(-2F, 10F, -7F);
      Head.setTextureSize(52, 29);
      Head.mirror = true;
      setRotation(Head, 0.2230705F, 0F, 0F);
      Beak = new ModelRenderer(this, 16, 14);
      Beak.addBox(0F, 0F, 0F, 4, 2, 2);
      Beak.setRotationPoint(-2F, 12.5F, -8.5F);
      Beak.setTextureSize(52, 29);
      Beak.mirror = true;
      setRotation(Beak, 0.2230717F, 0F, 0F);
      Neck = new ModelRenderer(this, 16, 18);
      Neck.addBox(0F, 0F, 0F, 2, 1, 1);
      Neck.setRotationPoint(-1F, 14F, -7F);
      Neck.setTextureSize(52, 29);
      Neck.mirror = true;
      setRotation(Neck, 0.2230717F, 0F, 0F);
      Body = new ModelRenderer(this, 0, 0);
      Body.addBox(0F, 0F, 0F, 6, 6, 8);
      Body.setRotationPoint(-3F, 14F, -4F);
      Body.setTextureSize(52, 29);
      Body.mirror = true;
      setRotation(Body, 0F, 0F, 0F);
      Wing2 = new ModelRenderer(this, 28, 10);
      Wing2.addBox(0F, 0F, 0F, 1, 4, 6);
      Wing2.setRotationPoint(3F, 14F, -3F);
      Wing2.setTextureSize(52, 29);
      Wing2.mirror = true;
      setRotation(Wing2, -0.5205006F, 0F, 0F);
      Wing1 = new ModelRenderer(this, 28, 0);
      Wing1.addBox(0F, 0F, 0F, 1, 4, 6);
      Wing1.setRotationPoint(-4F, 14F, -3F);
      Wing1.setTextureSize(52, 29);
      Wing1.mirror = true;
      setRotation(Wing1, -0.1858931F, 0F, 0F);
      Leg1 = new ModelRenderer(this, 0, 0);
      Leg1.addBox(0F, 0F, 0F, 1, 4, 0);
      Leg1.setRotationPoint(1F, 20F, 0F);
      Leg1.setTextureSize(52, 29);
      Leg1.mirror = true;
      setRotation(Leg1, 0F, 0F, 0F);
      Leg2 = new ModelRenderer(this, 0, 0);
      Leg2.addBox(0F, 0F, 0F, 1, 4, 0);
      Leg2.setRotationPoint(-2F, 20F, 0F);
      Leg2.setTextureSize(52, 29);
      Leg2.mirror = true;
      setRotation(Leg2, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Head.render(f5);
    Beak.render(f5);
    Neck.render(f5);
    Body.render(f5);
    Wing2.render(f5);
    Wing1.render(f5);
    Leg1.render(f5);
    Leg2.render(f5);
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
	this.Leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
	this.Leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;

  }

}
